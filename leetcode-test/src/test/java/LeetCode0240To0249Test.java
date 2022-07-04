import com.github.liao47.leetcode.P0241DifferentWaysToAddParentheses;
import com.github.liao47.leetcode.utils.AssertUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author liaoshiqing
 * @date 2022/7/1 14:41
 */
public class LeetCode0240To0249Test {
    @Test
    public void test0241() {
        P0241DifferentWaysToAddParentheses solver = new P0241DifferentWaysToAddParentheses();
        AssertUtils.assertList(Arrays.asList(0, 2), solver.diffWaysToCompute("2-1-1"));
        AssertUtils.assertList(Arrays.asList(-34, -14, -10, -10, 10), solver.diffWaysToCompute("2*3-4*5"));
        AssertUtils.assertList(Collections.singletonList(12), solver.diffWaysToCompute("12"));
        AssertUtils.assertList(Arrays.asList(60, 60), solver.diffWaysToCompute("15*1*4"));
    }

}
