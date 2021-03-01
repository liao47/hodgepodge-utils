package com.github.liao47.union.utils;

import com.github.liao47.common.exception.CustomException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.zip.Inflater;

/**
 * 解压缩工具
 * @author liao47
 * @date 2021/3/1 9:34
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InflaterUtils {
    /**
     * 解压缩并保存文件
     * @param data
     * @param fileDirectory
     * @param fileName
     * @param inflater
     * @param charset
     * @return
     */
    public static String inflaterAndSave(String data, String fileDirectory, String fileName,
                                         boolean inflater, Charset charset) {
        String filePath = fileDirectory + File.separator + fileName;
        if (StringUtils.isEmpty(data)) {
            return null;
        }

        File file = new File(filePath);
        try {
            File directory = new File(fileDirectory);
            if (!directory.exists() && !directory.mkdirs()) {
                log.info("创建路径[{}]失败", fileDirectory);
                throw new CustomException("创建路径失败");
            }
            if (!file.createNewFile()) {
                log.info("对账文件[{}]已存在", filePath);
                return filePath;
            }
        } catch (IOException e) {
            log.error("创建对账文件[{}]失败:", filePath, e);
            throw new CustomException("创建对账文件失败");
        }

        try (FileOutputStream out = new FileOutputStream(file)) {
            byte[] fileArray = Base64.decodeBase64(data.getBytes(charset));
            if (inflater) {
                fileArray = inflater(fileArray);
            }
            out.write(fileArray, 0, fileArray.length);
            out.flush();
        } catch (IOException e) {
            log.error("解压缩并保存文件失败:", e);
            throw new CustomException("解压缩并保存文件失败");
        }
        return filePath;
    }

    /**
     * 解压缩
     * @param inputByte
     * @return
     */
    public static byte[] inflater(final byte[] inputByte) {
        int compressedDataLength = 0;
        Inflater compressor = new Inflater(false);
        compressor.setInput(inputByte, 0, inputByte.length);
        byte[] result = new byte[1024];
        try (ByteArrayOutputStream o = new ByteArrayOutputStream(inputByte.length)) {
            while (!compressor.finished()) {
                compressedDataLength = compressor.inflate(result);
                if (compressedDataLength == 0) {
                    break;
                }
                o.write(result, 0, compressedDataLength);
            }
            compressor.end();
            return o.toByteArray();
        } catch (Exception ex) {
            log.error("解压缩失败:", ex);
            throw new CustomException("解压缩失败");
        }
    }
}
