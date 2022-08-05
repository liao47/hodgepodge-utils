import com.github.liao47.leetcode.P0622DesignCircularQueue;
import com.github.liao47.leetcode.P0623AddOneRowToTree;
import com.github.liao47.leetcode.bo.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author liaoshiqing
 * @date 2022/8/2 14:21
 */
public class LeetCode0620To0629Test {
    @Test
    public void test0622() {
        P0622DesignCircularQueue.MyCircularQueue queue = new P0622DesignCircularQueue.MyCircularQueue(3);
        Assert.assertTrue(queue.enQueue(1));
        Assert.assertTrue(queue.enQueue(2));
        Assert.assertTrue(queue.enQueue(3));
        Assert.assertFalse(queue.enQueue(4));
        Assert.assertEquals(3, queue.Rear());
        Assert.assertTrue(queue.isFull());
        Assert.assertTrue(queue.deQueue());
        Assert.assertTrue(queue.enQueue(4));
        Assert.assertEquals(4, queue.Rear());
        Assert.assertEquals(2, queue.Front());
    }

    @Test
    public void test0623() {
        P0623AddOneRowToTree solver = new P0623AddOneRowToTree();
        TreeNode root = TreeNode.of(new Integer[]{4, 2, 6, 3, 1, 5});
        List<Integer> ans = Arrays.asList(4, 1, 1, 2, null, null, 6, 3, 1, 5);
        Assert.assertEquals(ans, solver.addOneRow(root, 1, 2).toList());

        root = TreeNode.of(new Integer[]{4, 2, null, 3, 1});
        ans = Arrays.asList(4, 2, null, 1, 1, 3, null, null, 1);
        Assert.assertEquals(ans, solver.addOneRow(root, 1, 3).toList());
    }
}
