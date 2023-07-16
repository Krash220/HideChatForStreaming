package krash220.hidechat4s.utils;

import java.awt.MouseInfo;
import java.awt.Point;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class LWJGLHelper {
    public static final boolean isGLFW;

    private static int[] windowInfo = new int[4];
    private static int[][] buffer = new int[2][1];
    private static int[] lastPos;

    static {
        boolean glfw;

        try {
            Class.forName("org.lwjgl.glfw.GLFW");
            glfw = true;
        } catch (ClassNotFoundException e) {
            glfw = false;
        }

        isGLFW = glfw;
    }

    public static int[] getWindowInfo() {
        int[] out = windowInfo;

        if (isGLFW) {
            long window = GLFW.glfwGetCurrentContext();

            GLFW.glfwGetWindowPos(window, buffer[0], buffer[1]);

            out[0] = buffer[0][0];
            out[1] = buffer[1][0];

            GLFW.glfwGetWindowSize(window, buffer[0], buffer[1]);

            out[2] = buffer[0][0];
            out[3] = buffer[1][0];
        } else {
            out[0] = Display.getX();
            out[1] = Display.getY();
            out[2] = Display.getWidth();
            out[3] = Display.getHeight();

            if (Mouse.isInsideWindow()) {
                if (lastPos == null) {
                    lastPos = new int[2];
                }

                Point p = MouseInfo.getPointerInfo().getLocation();

                lastPos[0] = out[0] = p.x - Mouse.getEventX();
                lastPos[1] = out[1] = p.y - out[3] + 1 + Mouse.getEventY();
            } else if (lastPos != null) {
                out[0] = lastPos[0];
                out[1] = lastPos[1];
            }
        }

        return out;
    }

    public static boolean isFocused() {
        if (isGLFW) {
            long window = GLFW.glfwGetCurrentContext();

            return GLFW.glfwGetWindowAttrib(window, GLFW.GLFW_FOCUSED) != 0;
        } else {
            return Display.isActive();
        }
    }
}
