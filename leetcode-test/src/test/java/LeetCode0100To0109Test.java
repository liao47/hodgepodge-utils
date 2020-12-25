import com.github.liao47.leetcode.P0103BinaryTreeZigzagLevelOrderTraversal;
import com.github.liao47.leetcode.P0103BinaryTreeZigzagLevelOrderTraversal.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2020/12/22 9:41
 */
public class LeetCode0100To0109Test {
    @Test
    public void test0103() {
        P0103BinaryTreeZigzagLevelOrderTraversal solver = new P0103BinaryTreeZigzagLevelOrderTraversal();

        TreeNode root = TreeNode.of(new Integer[]{3, 9, 20, null, null, 15, 7});
        assertEquals("[[3], [20, 9], [15, 7]]", solver.zigzagLevelOrder(root).toString());

        root = TreeNode.of(new Integer[]{1, 2, 3, 4, null, null, 5});
        assertEquals("[[1], [3, 2], [4, 5]]", solver.zigzagLevelOrder(root).toString());
    }
}
