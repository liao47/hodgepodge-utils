package com.liao47.apt.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;

/**
 * 类搬运工具
 * @author liao47
 * @date 2020/10/30 16:14
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClassCarrier {

    private static final String SEPARATOR = "/";

    /**
     * 类搬运
     * 编译时可将类拷贝到工程下，防止工程对外提供包时无依赖报错
     * @param tClass
     * @return
     */
    public static String carryClass(Class<?> tClass) {
        try {
            String path = SEPARATOR + tClass.getCanonicalName().replace(".", SEPARATOR) + ".class";

            URL url = ClassCarrier.class.getClassLoader().getResource("");
            if (url == null) {
                return "Get project resource failure";
            }

            File file = new File(url.getPath() + path);
            if (file.exists()) {
                Files.delete(file.toPath());
            }
            File dir = file.getParentFile();
            if (!dir.exists() && !dir.mkdirs()) {
                return String.format("Mkdirs file path failure[%s]", dir.getPath());
            }

            Files.copy(tClass.getResourceAsStream(path), file.toPath());
            return null;
        } catch (Exception e) {
            return "Carry class file failure:" + e.getMessage();
        }
    }
}
