import com.github.liao47.leetcode.P0062UniquePaths;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2020/12/10 15:13
 */
public class LeetCode0060To0069Test {

    @Test
    public void test0062() {
        P0062UniquePaths solver = new P0062UniquePaths();

        assertEquals(28, solver.uniquePaths(3, 7));
        assertEquals(3, solver.uniquePaths(3, 2));
        assertEquals(28, solver.uniquePaths(7, 3));
        assertEquals(6, solver.uniquePaths(3, 3));
        assertEquals(193536720, solver.uniquePaths(23, 12));
    }
}
