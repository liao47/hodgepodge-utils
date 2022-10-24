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
     * 图片添加文本
     * @param imageIcon
     * @param params
     * @return
     */
    public static BufferedImage drawText(ImageIcon imageIcon, ImgDrawTextParams params) {
        Image image = imageIcon.getImage();
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
        int[] point = ImgDrawTextParams.Position.pointStart(imgWidth, imgHeight, width, height,
                params.getImgPosition());
        g.drawImage(image, point[0], point[1], null);

        if (params.getTextParams() != null && !params.getTextParams().isEmpty()) {
            for (ImgDrawTextParams.TextParam textParam : params.getTextParams()) {
                drawText(g, params, textParam, width, height);
            }
        }
        g.dispose();
        return bufferedImage;
    }

    /**
     * url图片添加文本
     * @param url
     * @param params
     */
    public static BufferedImage drawTextByUrl(String url, ImgDrawTextParams params) {
        try {
            return drawText(new ImageIcon(new URL(url)), params);
        } catch (MalformedURLException e) {
            log.error("图片URL[{}]格式不正确：", url, e);
            throw new CustomException("图片URL格式不正确");
        }
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

        int startX = textParam.getStartX() >= 0 ? textParam.getStartX() : width + textParam.getStartX();
        startX += margin;
        int startY = textParam.getStartY() >= 0 ? textParam.getStartY() : height + textParam.getStartY();
        startY += margin;

        int endX = textParam.getEndX() == null ? width : textParam.getEndX() >= 0 ? textParam.getEndX() :
                width + textParam.getEndX();
        endX -= margin;
        int endY = textParam.getEndY() == null ? height : textParam.getEndY() >= 0 ? textParam.getEndY() :
                height + textParam.getEndY();
        endY -= margin;

        int maxLine = (endY - startY + spacing) / (textHeight + spacing);
        if (maxLine <= 0) {
            return;
        }

        List<String> texts = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int wordWidth = 0;
        int line = 0;
        for (char c : textParam.getText().toCharArray()) {
            int charWidth = fontMetrics.charWidth(c);
            wordWidth += charWidth;
            if (wordWidth > endX - startX) {
                if (++line == maxLine) {
                    String overflow = ObjectUtils.defaultIfNull(textParam.getOverflow(), params.getOverflow());
                    int ow = fontMetrics.stringWidth(overflow);
                    int w = 0;
                    while (w < ow && sb.length() > 0) {
                        w += fontMetrics.charWidth(sb.charAt(sb.length() - 1));
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

        for (String text : texts) {
            //绘制阴影
            g.setColor(new Color(0, 0, 0, 64));
            g.drawString(text, startX, startY);
            //绘制正文
            g.setColor(ObjectUtils.defaultIfNull(textParam.getColor(), params.getTextColor()));
            g.drawString(text, startX, startY);
            startY += textHeight + spacing;
        }
    }
}
