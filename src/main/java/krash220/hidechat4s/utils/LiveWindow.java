package krash220.hidechat4s.utils;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class LiveWindow extends Thread {

    private static LiveWindow instance;

    public static void init() {
        System.setProperty("java.awt.headless", "false");
        GraphicsEnvironment.isHeadless();

        instance = new LiveWindow();
        instance.start();
    }

    public static boolean checkWindow(int x, int y, int width, int height) {
        if (instance.x != x || instance.y != y) {
            instance.x = x;
            instance.y = y;
            instance.move = true;
        }

        if (instance.width != width || instance.height != height) {
            instance.width = width;
            instance.height = height;
            instance.resize = true;
        }

        return instance.resize;
    }

    public static int[] getPixelBuffer() {
        return instance.data;
    }

    public static void updateDisplay() {
        instance.draw = true;
    }

    private Frame parent;
    private Dialog window;

    private Graphics graph;
    private Image image;

    private int x = 0;
    private int y = 0;
    private int width = 1;
    private int height = 1;
    private int[] data = null;

    private boolean draw = false;
    private boolean move = false;
    private boolean resize = false;

    private LiveWindow() {
        if (instance != null) {
            throw new RuntimeException("Created!");
        }

        this.parent = new Frame();
        this.window = new Dialog(this.parent, "【直播模式】Minecraft");

        this.window.setUndecorated(true);
        this.window.setOpacity(0);
        this.window.setBounds(0, 0, 1, 1);
        this.window.setFocusableWindowState(false);
        this.window.setBackground(Color.BLACK);
        this.window.setVisible(true);

        this.initGraphics();
    }

    public void initGraphics() {
        this.graph = this.window.getGraphics();
        this.image = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_BGR);

        BufferedImage b = (BufferedImage) this.image;
        DataBufferInt d = (DataBufferInt) b.getRaster().getDataBuffer();

        this.data = d.getData();
        this.draw = false;
    }

    @Override
    public void run() {
        while (true) {
            if (this.move) {
                this.window.setLocation(this.x, this.y);

                this.move = false;
            }

            if (this.resize) {
                this.window.setSize(this.width, this.height);
                this.initGraphics();

                this.resize = false;
            } else if (this.draw) {
                this.graph.drawImage(this.image, 0, 0, this.width, this.height, 0, this.height, this.width, 0, null);

                this.draw = false;
            }

            try {
                Thread.sleep(0L);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
