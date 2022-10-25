package com.github.liao47.utils.bo;

import lombok.Data;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 图片添加文本参数
 * @author liaoshiqing
 * @date 2022/10/24 9:23
 */
@Data
public class ImgDrawTextParams {
    /**
     * 宽度扩展像素
     */
    private Integer extendWidth;

    /**
     * 高度扩展像素
     */
    private Integer extendHeight;

    /**
     * 背景颜色
     */
    private Color background = Color.WHITE;

    /**
     * 图像位置
     */
    private Position imgPosition = Position.TOP_LEFT;

    /**
     * 文本参数
     */
    private List<TextParam> textParams;

    //******** 以下为统一配置：优先取文本参数配置，文本参数未配置对应项，则取统一配置 **********

    /**
     * 字体
     */
    private Font font = new Font("微软雅黑", Font.PLAIN, 24);

    /**
     * 字体颜色
     */
    private Color color = Color.DARK_GRAY;

    /**
     * 边缘
     */
    private Integer margin;

    /**
     * 自动换行
     */
    private Boolean wrap = Boolean.TRUE;

    /**
     * 超出部分隐藏显示
     * 超出画布范围显示字符，如"..."
     */
    private String overflow;

    /**
     * 行间距
     */
    private Integer spacing = 10;

    /**
     * 添加文本配置
     * @param textParam
     * @return
     */
    public ImgDrawTextParams addText(TextParam textParam) {
        if (textParam != null) {
            if (textParams == null) {
                textParams = new ArrayList<>();
            }
            textParams.add(textParam);
        }
        return this;
    }

    /**
     * 图像位置
     * @author liaoshiqing
     * @date 2022/10/25 17:25
     */
    public enum Position {
        /**
         * 左上 中上 右上
         * 左中 中间 右中
         * 左下 中下 右下
         */
        TOP_LEFT,     TOP_MID,      TOP_RIGHT,
        MID_LEFT,       MID,        MID_RIGHT,
        BOTTOM_LEFT, BOTTOM_MID, BOTTOM_RIGHT;

        public static int[] startPoint(int imgW, int imgH, int w, int h, Position position) {
            int midX = (w - imgW) >> 1;
            int midY = (h - imgH) >> 1;
            switch (position) {
                case TOP_MID:
                    return new int[]{midX, 0};
                case TOP_RIGHT:
                    return new int[]{w - imgW, 0};
                case MID_LEFT:
                    return new int[]{0, midY};
                case MID:
                    return new int[]{midX, midY};
                case MID_RIGHT:
                    return new int[]{w - imgW, midY};
                case BOTTOM_LEFT:
                    return new int[]{0, h - imgH};
                case BOTTOM_MID:
                    return new int[]{midX, h - imgH};
                case BOTTOM_RIGHT:
                    return new int[]{w - imgW, h - imgH};
                default:
                    return new int[]{0, 0};
            }
        }
    }

    /**
     * 文本配置
     * @author liaoshiqing
     * @date 2022/10/25 16:56
     */
    @Data
    public static class TextParam {
        /**
         * 文本
         */
        private String text;

        /**
         * 开始位置x，负值表示距离右边像素值
         */
        private Integer startX;

        /**
         * 开始位置y，负值表示距离下边像素值
         */
        private Integer startY;

        /**
         * 结束位置x，负值表示距离右边像素值
         */
        private Integer endX;

        /**
         * 结束位置y，负值表示距离下边像素值
         */
        private Integer endY;

        /**
         * 字体
         */
        private Font font;

        /**
         * 颜色
         */
        private Color color;

        /**
         * 边缘
         */
        private Integer margin;

        /**
         * 自动换行
         */
        private Boolean wrap;

        /**
         * 行间距
         */
        private Integer spacing;

        /**
         * 超出部分隐藏显示
         */
        private String overflow;
    }
}
