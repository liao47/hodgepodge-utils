package com.github.liao47.utils.test.pojo;

import lombok.Data;

/**
 * A
 * @author liaoshiqing
 * @date 2020/10/29 11:10
 */
@Data
public class ClassA {
    private ClassB b;

    private String fieldStr;

    private Long fieldLong;

    public static ClassA of(String name, String fieldStr, Long fieldLong) {
        ClassA a = new ClassA();
        a.setB(new ClassB(name));
        a.setFieldStr(fieldStr);
        a.setFieldLong(fieldLong);
        return a;
    }
}
