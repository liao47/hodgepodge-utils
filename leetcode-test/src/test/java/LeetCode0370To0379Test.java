import com.github.liao47.leetcode.LeetCode0376;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2020/12/12 9:45
 */
public class LeetCode0370To0379Test {
    @Test
    public void test0376() {
        LeetCode0376 solver = new LeetCode0376();
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
