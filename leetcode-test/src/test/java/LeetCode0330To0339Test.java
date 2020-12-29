import com.github.liao47.leetcode.P0330PatchingArray;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2020/12/29 17:30
 */
public class LeetCode0330To0339Test {
    @Test
    public void test0330() {
        P0330PatchingArray solver = new P0330PatchingArray();

        assertEquals(1, solver.minPatches(new int[]{1, 3}, 6));
        assertEquals(2, solver.minPatches(new int[]{1, 5, 10}, 20));
        assertEquals(0, solver.minPatches(new int[]{1, 2, 2}, 5));
        assertEquals(28, solver.minPatches(new int[]{1, 2, 31, 33}, 2147483647));
    }
}
