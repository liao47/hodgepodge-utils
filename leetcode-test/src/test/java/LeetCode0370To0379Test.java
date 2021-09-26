import com.github.liao47.leetcode.P0371SumOfWwoIntegers;
import com.github.liao47.leetcode.P0376WiggleSubsequence;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2020/12/12 9:45
 */
public class LeetCode0370To0379Test {
    @Test
    public void test0371() {
        P0371SumOfWwoIntegers solver = new P0371SumOfWwoIntegers();
        Assert.assertEquals(3, solver.getSum(1, 2));
        Assert.assertEquals(5, solver.getSum(2, 3));
        Assert.assertEquals(2, solver.getSum(2, 0));
        Assert.assertEquals(-5, solver.getSum(-2, -3));
    }

    @Test
    public void test0376() {
        P0376WiggleSubsequence solver = new P0376WiggleSubsequence();
        assertEquals(6, solver.wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));
        assertEquals(7, solver.wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
        assertEquals(2, solver.wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        assertEquals(1, solver.wiggleMaxLength(new int[]{0, 0}));

        assertEquals(6, solver.wiggleMaxLength2(new int[]{1, 7, 4, 9, 2, 5}));
        assertEquals(7, solver.wiggleMaxLength2(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
        assertEquals(2, solver.wiggleMaxLength2(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        assertEquals(1, solver.wiggleMaxLength2(new int[]{0, 0}));
    }
}
