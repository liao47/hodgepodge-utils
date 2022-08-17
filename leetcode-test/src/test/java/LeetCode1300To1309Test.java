import com.github.liao47.leetcode.P1302DeepestLeavesSum;
import com.github.liao47.leetcode.bo.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/8/17 10:41
 */
public class LeetCode1300To1309Test {
    @Test
    public void test1302() {
        P1302DeepestLeavesSum solver = new P1302DeepestLeavesSum();
        TreeNode root = TreeNode.of(new Integer[]{1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8});
        Assert.assertEquals(15, solver.deepestLeavesSum(root));
        root = TreeNode.of(new Integer[]{6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5});
        Assert.assertEquals(19, solver.deepestLeavesSum(root));
    }
}
