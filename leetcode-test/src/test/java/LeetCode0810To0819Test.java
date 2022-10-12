import com.github.liao47.leetcode.P0814BinaryTreePruning;
import com.github.liao47.leetcode.P0817LinkedListComponents;
import com.github.liao47.leetcode.bo.ListNode;
import com.github.liao47.leetcode.bo.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author liaoshiqing
 * @date 2022/7/21 9:55
 */
public class LeetCode0810To0819Test {
    @Test
    public void test0814() {
        P0814BinaryTreePruning solver = new P0814BinaryTreePruning();
        TreeNode root = TreeNode.of(new Integer[]{1, null, 0, 0, 1});
        Assert.assertEquals(Arrays.asList(1, null, 0, null, 1), solver.pruneTree(root).toList());

        root = TreeNode.of(new Integer[]{1, 0, 1, 0, 0, 0, 1});
        Assert.assertEquals(Arrays.asList(1, null, 1, null, 1), solver.pruneTree(root).toList());

        root = TreeNode.of(new Integer[]{1, 1, 0, 1, 1, 0, 1, 0});
        Assert.assertEquals(Arrays.asList(1, 1, 0, 1, 1, null, 1), solver.pruneTree(root).toList());
    }

    @Test
    public void test0817() {
        P0817LinkedListComponents solver = new P0817LinkedListComponents();
        ListNode head = ListNode.of(new int[]{0, 1, 2, 3});
        Assert.assertEquals(2, solver.numComponents(head, new int[]{0, 1, 3}));
        head = ListNode.of(new int[]{0, 1, 2, 3, 4});
        Assert.assertEquals(2, solver.numComponents(head, new int[]{0, 3, 1, 4}));
    }
}
