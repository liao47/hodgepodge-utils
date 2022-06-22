import com.github.liao47.leetcode.P0513FindBottomLeftTreeValue;
import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liaoshiqing
 * @date 2022/6/22 13:52
 */
public class LeetCode0510To0519Test {
    @Test
    public void test0513() {
        P0513FindBottomLeftTreeValue solver = new P0513FindBottomLeftTreeValue();
        Integer[] params = new Integer[]{2, 1, 3};
        Assert.assertEquals(1, solver.findBottomLeftValue(parseTreeNode0513(params)));
        params = new Integer[]{1, 2, 3, 4, null, 5, 6, null, null, 7};
        Assert.assertEquals(7, solver.findBottomLeftValue(parseTreeNode0513(params)));
        params = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Assert.assertEquals(8, solver.findBottomLeftValue(parseTreeNode0513(params)));
    }

    private P0513FindBottomLeftTreeValue.TreeNode parseTreeNode0513(Integer[] params) {
        P0513FindBottomLeftTreeValue.TreeNode root = new P0513FindBottomLeftTreeValue.TreeNode(params[0]);
        Deque<P0513FindBottomLeftTreeValue.TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int i = 1;
        while (i < params.length) {
            Integer left = params[i++];
            Integer right = i < params.length ? params[i++] : null;

            P0513FindBottomLeftTreeValue.TreeNode node = deque.poll();
            if (node == null) {
                break;
            }
            if (left != null) {
                node.left = new P0513FindBottomLeftTreeValue.TreeNode(left);
                deque.offer(node.left);
            }
            if (right != null) {
                node.right = new P0513FindBottomLeftTreeValue.TreeNode(right);
                deque.offer(node.right);
            }
        }
        return root;
    }
}
