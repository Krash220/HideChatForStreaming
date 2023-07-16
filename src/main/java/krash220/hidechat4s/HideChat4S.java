package krash220.hidechat4s;

import java.nio.ByteBuffer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL21;

import krash220.hidechat4s.launcher.IMod;
import krash220.hidechat4s.launcher.ModLauncher;
import krash220.hidechat4s.launcher.ModLauncher.Event;
import krash220.hidechat4s.utils.LWJGLHelper;
import krash220.hidechat4s.utils.LiveWindow;

public class HideChat4S implements IMod {

    private int width;
    private int height;

    private int[] pbo;
    private boolean front;
    private boolean captured;
    private ByteBuffer oldBuffer;

    private boolean capturedBeforeChat;

    @Override
    public void init() {
        ModLauncher.register(Event.RENDER_START, this::checkLiveWindow);
        ModLauncher.register(Event.RENDER_END, this::updateLiveWindow);
        ModLauncher.register(Event.RENDER_CHAT_START, this::captureBeforeChat);

        this.oldBuffer = null;

        LiveWindow.init();
    }

    private void resetPBO() {
        if (this.pbo == null) {
            this.pbo = new int[] {
                    GL15.glGenBuffers(),
                    GL15.glGenBuffers()
            };

            this.front = true;
            this.captured = false;
        }

        GL15.glBindBuffer(GL21.GL_PIXEL_PACK_BUFFER, this.pbo[0]);
        GL15.glBufferData(GL21.GL_PIXEL_PACK_BUFFER, this.width * this.height * 4, GL15.GL_STREAM_DRAW);
        GL15.glBindBuffer(GL21.GL_PIXEL_PACK_BUFFER, this.pbo[1]);
        GL15.glBufferData(GL21.GL_PIXEL_PACK_BUFFER, this.width * this.height * 4, GL15.GL_STREAM_DRAW);
        GL15.glBindBuffer(GL21.GL_PIXEL_PACK_BUFFER, GL11.GL_NONE);
    }

    public void captureBeforeChat() {
        if (this.pbo == null) {
            return;
        }

        this.capturedBeforeChat = true;
        this.doCapture();
    }

    public void updateLiveWindow() {
        if (this.pbo == null) {
            return;
        }

        if (this.captured) {
            GL15.glBindBuffer(GL21.GL_PIXEL_PACK_BUFFER, this.getBack());
            this.oldBuffer = GL15.glMapBuffer(GL21.GL_PIXEL_PACK_BUFFER, GL15.GL_READ_ONLY, this.oldBuffer);
            this.oldBuffer.asIntBuffer().get(LiveWindow.getPixelBuffer());
            GL15.glUnmapBuffer(GL21.GL_PIXEL_PACK_BUFFER);
            GL15.glBindBuffer(GL21.GL_PIXEL_PACK_BUFFER, GL11.GL_NONE);

            LiveWindow.updateDisplay();
        }

        if (!this.capturedBeforeChat) {
            this.doCapture();
        }

        this.capturedBeforeChat = false;
        this.swap();
    }

    public void checkLiveWindow() {
        if (this.checkResize()) {
            this.resetPBO();
        }
    }

    private boolean checkResize() {
        int[] win = LWJGLHelper.getWindowInfo();

        if (LiveWindow.checkWindow(win[0], win[1], win[2], win[3]) || this.pbo == null) {
            this.width = win[2];
            this.height = win[3];

            return true;
        }

        return false;
    }

    private void swap() {
        this.front = !this.front;
        this.captured = true;
    }

    private int getFront() {
        return this.front ? this.pbo[0] : this.pbo[1];
    }

    private int getBack() {
        return this.front ? this.pbo[1] : this.pbo[0];
    }

    private void doCapture() {
        GL15.glBindBuffer(GL21.GL_PIXEL_PACK_BUFFER, this.getFront());
        GL11.glReadPixels(0, 0, this.width, this.height, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, 0);
        GL15.glBindBuffer(GL21.GL_PIXEL_PACK_BUFFER, GL11.GL_NONE);
    }
}
