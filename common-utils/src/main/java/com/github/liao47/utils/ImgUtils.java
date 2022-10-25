package com.github.liao47.utils;

import com.github.liao47.common.exception.CustomException;
import com.github.liao47.utils.bo.ImgDrawTextParams;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liaoshiqing
 * @date 2021/10/25 9:42
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ImgUtils {

    /**
     * url图片添加文本
     * @param url
     * @param params
     */
    public static BufferedImage drawTextByUrl(String url, ImgDrawTextParams params) {
        try {
            ImageIcon imageIcon = new ImageIcon(new URL(url));
            return drawText(imageIcon.getImage(), params);
        } catch (MalformedURLException e) {
            log.error("图片URL[{}]格式不正确：", url, e);
            throw new CustomException("图片URL格式不正确");
        }
    }

    /**
     * 图片添加文本
     * @param imageData
     * @param params
     * @return
     */
    public static BufferedImage drawText(byte[] imageData, ImgDrawTextParams params) {
        ImageIcon imageIcon = new ImageIcon(imageData);
        return drawText(imageIcon.getImage(), params);
    }

    /**
     * 图片添加文本
     * @param image
     * @param params
     * @return
     */
    public static BufferedImage drawText(Image image, ImgDrawTextParams params) {
        int imgWidth = image.getWidth(null);
        int imgHeight = image.getHeight(null);
        int width = imgWidth + ObjectUtils.defaultIfNull(params.getExtendWidth(), 0);
        int height = imgHeight + ObjectUtils.defaultIfNull(params.getExtendHeight(), 0);

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics2D g = bufferedImage.createGraphics();
        //抗锯齿
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setBackground(params.getBackground());

        //画布扩展部分背景
        g.clearRect(0, 0, width, height);
        int[] point = ImgDrawTextParams.Position.startPoint(imgWidth, imgHeight, width, height,
                params.getImgPosition());
        g.drawImage(image, point[0], point[1], null);

        if (HandyUtils.isNotEmpty(params.getTextParams())) {
            for (ImgDrawTextParams.TextParam textParam : params.getTextParams()) {
                drawText(g, params, textParam, width, height);
            }
        }
        g.dispose();
        return bufferedImage;
    }

    /**
     * 绘制文本
     * @param g
     * @param params
     * @param textParam
     * @param width
     * @param height
     */
    private static void drawText(Graphics2D g, ImgDrawTextParams params, ImgDrawTextParams.TextParam textParam,
                                 int width, int height) {
        if (StringUtils.isEmpty(textParam.getText())
                || textParam.getStartX() == null || textParam.getStartY() == null) {
            return;
        }

        g.setFont(ObjectUtils.defaultIfNull(textParam.getFont(), params.getFont()));
        JLabel label = new JLabel(textParam.getText());
        label.setFont(g.getFont());
        FontMetrics fontMetrics = label.getFontMetrics(g.getFont());
        int textHeight = fontMetrics.getHeight();
        int margin = ObjectUtils.defaultIfNull(params.getMargin(), 0);
        int spacing = ObjectUtils.defaultIfNull(textParam.getSpacing(), params.getSpacing());

        int startX = fixed(textParam.getStartX(), width) + margin;
        int startY = fixed(textParam.getStartY(), height) + margin;
        int endX = fixed(textParam.getEndX(), width) - margin;
        int endY = fixed(textParam.getEndY(), height) - margin;

        int maxLine = (endY - startY + spacing) / (textHeight + spacing);
        if (maxLine <= 0) {
            return;
        }
        if (!Boolean.TRUE.equals(ObjectUtils.defaultIfNull(textParam.getWrap(), params.getWrap()))) {
            maxLine = 1;
        }

        List<String> texts = wrap(textParam.getText(), fontMetrics, maxLine, endX - startX,
                ObjectUtils.defaultIfNull(textParam.getOverflow(), params.getOverflow()));
        for (String text : texts) {
            //绘制阴影
            g.setColor(new Color(0, 0, 0, 64));
            g.drawString(text, startX, startY);
            //绘制正文
            g.setColor(ObjectUtils.defaultIfNull(textParam.getColor(), params.getColor()));
            g.drawString(text, startX, startY);
            startY += textHeight + spacing;
        }
    }

    /**
     * 分行
     * @param text
     * @param fontMetrics
     * @param maxLine
     * @param lineWidth
     * @param overflow
     * @return
     */
    private static List<String> wrap(String text, FontMetrics fontMetrics,
                                     int maxLine, int lineWidth, String overflow) {
        List<String> texts = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int wordWidth = 0;
        int line = 0;
        for (char c : text.toCharArray()) {
            int charWidth = fontMetrics.charWidth(c);
            wordWidth += charWidth;
            if (wordWidth > lineWidth) {
                if (++line == maxLine) {
                    int overflowWidth = fontMetrics.stringWidth(overflow);
                    int width = 0;
                    while (width < overflowWidth && sb.length() > 0) {
                        width += fontMetrics.charWidth(sb.charAt(sb.length() - 1));
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    sb.append(overflow);
                    texts.add(sb.toString());
                    break;
                }

                texts.add(sb.toString());
                sb = new StringBuilder();
                wordWidth = charWidth;
            }
            sb.append(c);
        }
        if (sb.length() > 0 && line < maxLine) {
            texts.add(sb.toString());
        }
        return texts;
    }

    /**
     * 绝对位置
     * @param val
     * @param limit
     * @return
     */
    private static int fixed(Integer val, int limit) {
        if (val == null) {
            //起始位置限制非空，这里直接返回结束位置
            return limit;
        }
        return val >= 0 ? val : limit + val;
    }
}
