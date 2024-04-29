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
        byte code = 0;
        Assert.assertEquals(TaskState.DRAFT, EnumUtils.get(code, TaskState::getCode, TaskState.class));
        Assert.assertTrue(EnumUtils.in(code, TaskState::getCode, TaskState.DRAFT, TaskState.DISABLE));
        Assert.assertFalse(EnumUtils.in(code, TaskState::getCode, TaskState.ENABLE, TaskState.DISABLE));
        Assert.assertTrue(EnumUtils.notIn(code, TaskState::getCode, TaskState.ENABLE, TaskState.DISABLE));

        Assert.assertEquals(TaskState.DRAFT, EnumUtils.getByCode(code, TaskState.class));
        Assert.assertTrue(EnumUtils.codeIn((byte) 0, TaskState.DRAFT, TaskState.DISABLE));
        Assert.assertFalse(EnumUtils.codeIn((byte) 0, TaskState.ENABLE, TaskState.DISABLE));
        Assert.assertTrue(EnumUtils.codeNotIn((byte) 0, TaskState.ENABLE, TaskState.DISABLE));

        Assert.assertFalse(EnumUtils.in(TaskState.DRAFT, TaskState::getCode, TaskState.DISABLE, TaskState.ENABLE));
        Assert.assertFalse(EnumUtils.in(TaskState.DRAFT, TaskState::getCode));
        Assert.assertTrue(EnumUtils.codeIn((byte) 0, TaskState.DRAFT));
        Assert.assertNull(EnumUtils.getByCode((byte) -1, TaskState.class));
        Assert.assertThrows(CustomException.class, () -> EnumUtils.getByCode((byte) -1, TaskState.class, "状态值有误"));
    }
}
