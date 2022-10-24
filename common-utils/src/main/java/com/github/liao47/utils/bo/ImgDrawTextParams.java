package com.github.liao47.utils.bo;

import lombok.Data;

import java.awt.*;
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
     * 全局字体
     */
    private Font font = new Font("微软雅黑", Font.PLAIN, 20);

    /**
     * 全局字体颜色
     */
    private Color textColor = Color.DARK_GRAY;

    /**
     * 边缘全局配置
     */
    private Integer margin;

    /**
     * 自动换行全局配置
     */
    private boolean wrap;

    /**
     * 超出部分隐藏显示全局配置
     * 超出画布范围显示字符，如"..."
     */
    private String overflow;

    /**
     * 行间距全局配置
     */
    private Integer spacing = 10;

    /**
     * 文本参数
     */
    private List<TextParam> textParams;

    public enum Position {
        /**
         * 图像位置
         */
        TOP_LEFT, TOP_MID, TOP_RIGHT,
        MID_LEFT, MID, MID_RIGHT,
        BOTTOM_LEFT, BOTTOM_MID, BOTTOM_RIGHT;

        public static int[] pointStart(int imgW, int imgH, int w, int h, Position position) {
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
        private boolean wrap;

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
