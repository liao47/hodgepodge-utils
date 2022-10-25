import com.github.liao47.leetcode.P0915PartitionArrayIntoDisjointIntervals;
import com.github.liao47.leetcode.P0919CompleteBinaryTreeInserter;
import com.github.liao47.leetcode.bo.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author liaoshiqing
 * @date 2022/7/25 14:28
 */
public class LeetCode0910To0919Test {
    @Test
    public void test0915() {
        P0915PartitionArrayIntoDisjointIntervals solver = new P0915PartitionArrayIntoDisjointIntervals();
        Assert.assertEquals(3, solver.partitionDisjoint(new int[]{5, 0, 3, 8, 6}));
        Assert.assertEquals(4, solver.partitionDisjoint(new int[]{1, 1, 1, 0, 6, 12}));
        Assert.assertEquals(1, solver.partitionDisjoint(new int[]{1, 1, 1}));
        Assert.assertEquals(1, solver.partitionDisjoint(new int[]{26, 51, 40, 58, 42, 76, 30, 48, 79, 91}));
        Assert.assertEquals(3, solver.partitionDisjoint(new int[]{3, 1, 2, 5, 4, 6, 7}));
        Assert.assertEquals(7, solver.partitionDisjoint(new int[]{32, 57, 24, 19, 0, 24, 49, 67, 87, 87}));
    }

    @Test
    public void test0919() {
        TreeNode root = TreeNode.of(new Integer[]{1, 2});
        P0919CompleteBinaryTreeInserter.CBTInserter inserter = new P0919CompleteBinaryTreeInserter.CBTInserter(root);
        Assert.assertEquals(1, inserter.insert(3));
        Assert.assertEquals(2, inserter.insert(4));
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4), inserter.get_root().toList());
    }
}
