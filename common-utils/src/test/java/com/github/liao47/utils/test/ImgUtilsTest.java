package com.github.liao47.utils.test;

import com.github.liao47.utils.ImgUtils;
import com.github.liao47.utils.bo.ImgDrawTextParams;
import org.junit.Assert;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liaoshiqing
 * @date 2022/10/24 13:58
 */
public class ImgUtilsTest {
    @Test
    public void testDrawText() {
        ImgDrawTextParams params = new ImgDrawTextParams();
        params.setExtendWidth(200);
        params.setExtendHeight(200);
        params.setImgPosition(ImgDrawTextParams.Position.TOP_MID);
        params.setBackground(Color.GRAY);
        params.setWrap(true);
        params.setOverflow("...");
        params.setMargin(10);
        params.setFont(new Font("幼圆", Font.PLAIN, 24));
        List<ImgDrawTextParams.TextParam> list = new ArrayList<>();
        params.setTextParams(list);

        ImgDrawTextParams.TextParam textParam = new ImgDrawTextParams.TextParam();
        textParam.setText("仅代购限制门店使用优惠券，文本有点长，文本有点长，文本有点长，文本有点长，文本有点长，文本有点长，文本有点长");
        textParam.setStartX(100);
        textParam.setStartY(-150);
        textParam.setEndX(-100);
        list.add(textParam);

        textParam = new ImgDrawTextParams.TextParam();
        textParam.setText("第二段文本：在右边显示");
        textParam.setStartX(-100);
        textParam.setStartY(30);
        list.add(textParam);

        textParam = new ImgDrawTextParams.TextParam();
        textParam.setText("第三段文本：在左边显示，这段文本有点长了");
        textParam.setStartX(10);
        textParam.setStartY(30);
        textParam.setEndX(100);
        textParam.setEndY(300);
        textParam.setFont(new Font("微软雅黑", Font.PLAIN, 24));
        list.add(textParam);

        BufferedImage bufferedImage = ImgUtils.drawTextByUrl("https://test-perfect-oss-uc2.oss-cn-shenzhen.aliyuncs.com/mall-center-member/20221021155751R7hYL.png", params);
        Assert.assertNotNull(bufferedImage);
        try (FileOutputStream out = new FileOutputStream("C:\\360极速浏览器X下载\\qrcode.png")) {
            ImageIO.write(bufferedImage, "JPEG", out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
