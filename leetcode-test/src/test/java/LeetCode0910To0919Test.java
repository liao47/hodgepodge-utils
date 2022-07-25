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
    public void test0919() {
        TreeNode root = TreeNode.of(new Integer[]{1, 2});
        P0919CompleteBinaryTreeInserter.CBTInserter inserter = new P0919CompleteBinaryTreeInserter.CBTInserter(root);
        Assert.assertEquals(1, inserter.insert(3));
        Assert.assertEquals(2, inserter.insert(4));
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4), inserter.get_root().toList());
    }
}
