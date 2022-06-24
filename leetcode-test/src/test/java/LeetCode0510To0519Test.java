import com.github.liao47.leetcode.P0513FindBottomLeftTreeValue;
import com.github.liao47.leetcode.P0515FindLargestValueInEachTreeRow;
import com.github.liao47.leetcode.bo.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author liaoshiqing
 * @date 2022/6/22 13:52
 */
public class LeetCode0510To0519Test {
    @Test
    public void test0513() {
        P0513FindBottomLeftTreeValue solver = new P0513FindBottomLeftTreeValue();
        Integer[] params = new Integer[]{2, 1, 3};
        Assert.assertEquals(1, solver.findBottomLeftValue(TreeNode.of(params)));
        params = new Integer[]{1, 2, 3, 4, null, 5, 6, null, null, 7};
        Assert.assertEquals(7, solver.findBottomLeftValue(TreeNode.of(params)));
        params = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Assert.assertEquals(8, solver.findBottomLeftValue(TreeNode.of(params)));
    }

    @Test
    public void test0515() {
        P0515FindLargestValueInEachTreeRow solver = new P0515FindLargestValueInEachTreeRow();
        Integer[] params = new Integer[]{1, 3, 2, 5, 3, null, 9};
        Assert.assertEquals(Arrays.asList(1, 3, 9), solver.largestValues(TreeNode.of(params)));
        params = new Integer[]{1, 2, 3};
        Assert.assertEquals(Arrays.asList(1, 3), solver.largestValues(TreeNode.of(params)));
    }
}
