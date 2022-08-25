package com.github.liao47.utils.test;

import com.github.liao47.common.exception.CustomException;
import com.github.liao47.utils.EnumUtils;
import com.github.liao47.utils.test.pojo.TaskState;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/8/19 17:51
 */
public class EnumUtilsTest {
    @Test
    public void test() {
        Assert.assertEquals(TaskState.DRAFT, EnumUtils.getEnum(TaskState.class, TaskState::getCode, (byte) 0));
        Assert.assertTrue(EnumUtils.in(TaskState::getCode, (byte) 0, TaskState.DRAFT, TaskState.DISABLE));
        Assert.assertFalse(EnumUtils.in(TaskState::getCode, (byte) 0, TaskState.ENABLE, TaskState.DISABLE));
        Assert.assertTrue(EnumUtils.notIn(TaskState::getCode, (byte) 0, TaskState.ENABLE, TaskState.DISABLE));

        Assert.assertEquals(TaskState.DRAFT, EnumUtils.getEnumByCode(TaskState.class, (byte) 0));
        Assert.assertTrue(EnumUtils.in((byte) 0, TaskState.DRAFT, TaskState.DISABLE));
        Assert.assertFalse(EnumUtils.in((byte) 0, TaskState.ENABLE, TaskState.DISABLE));
        Assert.assertTrue(EnumUtils.notIn((byte) 0, TaskState.ENABLE, TaskState.DISABLE));

        Assert.assertFalse(EnumUtils.in(TaskState::getCode, TaskState.DRAFT, TaskState.DISABLE, TaskState.ENABLE));
        Assert.assertFalse(EnumUtils.in(TaskState::getCode, TaskState.DRAFT));
        Assert.assertTrue(EnumUtils.in((byte) 0, TaskState.DRAFT));
        Assert.assertNull(EnumUtils.getEnumByCode(TaskState.class, (byte) -1));
        Assert.assertThrows(CustomException.class, () -> EnumUtils.getEnumByCode(TaskState.class, (byte) -1, "状态值有误"));
    }
}
