import com.github.liao47.leetcode.P1046LastStoneWeight;
import com.github.liao47.leetcode.P1145BinaryTreeColoringGame;
import com.github.liao47.leetcode.bo.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2020/12/30 15:30
 */
public class LeetCode1040To1049Test {
    @Test
    public void test1145() {
        P1145BinaryTreeColoringGame solver = new P1145BinaryTreeColoringGame();
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        Assert.assertTrue(solver.btreeGameWinningMove(TreeNode.of(arr), 11, 3));
        arr = new Integer[]{1, 2, 3};
        Assert.assertFalse(solver.btreeGameWinningMove(TreeNode.of(arr), 3, 1));
        arr = new Integer[]{6, 3, null, 7, 4, null, null, null, 2, null, 1, null, 5};
        Assert.assertTrue(solver.btreeGameWinningMove(TreeNode.of(arr), 7, 3));
    }

    @Test
    public void test1046() {
        P1046LastStoneWeight solver = new P1046LastStoneWeight();
        assertEquals(1, solver.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        assertEquals(2, solver.lastStoneWeight(new int[]{3, 7, 2}));
        assertEquals(2, solver.lastStoneWeight(new int[]{3, 7, 8}));
        assertEquals(3, solver.lastStoneWeight(new int[]{3}));
        assertEquals(2, solver.lastStoneWeight(new int[]{1, 3}));
    }
}
