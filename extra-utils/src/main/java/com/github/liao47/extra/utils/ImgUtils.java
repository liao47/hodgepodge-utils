package com.github.liao47.extra.utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author liaoshiqing
 * @date 2021/10/25 9:42
 */
public class ImgUtils {
    public static void drawText(String imgPath) throws MalformedURLException {
        URL url = new URL(imgPath);
        ImageIcon imageIcon = new ImageIcon(url);
        Image image = imageIcon.getImage();
        int width = image.getWidth(null);
        int height = image.getHeight(null);

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bufferedImage.createGraphics();
        //抗锯齿
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setBackground(Color.WHITE);
        g.drawImage(image, 0, 0, null);
        g.setFont(new Font("幼圆", Font.PLAIN, 30));
        //绘制阴影
        g.setColor(new Color(0, 0, 0, 64));
        g.drawString("张三", width * 0.6F, height * 0.46F);
        //绘制正文
        g.setColor(Color.DARK_GRAY);
        g.drawString("张三", width * 0.6F, height * 0.46F);
        g.dispose();
        try (FileOutputStream out = new FileOutputStream("C:\\Users\\ligeit\\Pictures\\happy_birthday2.png")) {
            ImageIO.write(bufferedImage, "JPEG", out);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("完成");

        /*response.setContentType("image/png");
        ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
        response.flushBuffer();*/
    }

    public static void main(String[] args) throws MalformedURLException {
        System.out.println("Start");
        drawText("https://dev-perfect-oss-uc2.oss-cn-shenzhen.aliyuncs.com/mall-center-promotion/202110251348333Lm28.png");
        System.out.println("End");
        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime());
        System.out.println(System.nanoTime());
        System.exit(0);
    }
}
