import com.github.liao47.leetcode.P0947MostStonesRemovedWithSameRowOrColumn;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2021/1/15 10:51
 */
public class LeetCode0940To0949Test {
    @Test
    public void test0947() {
        P0947MostStonesRemovedWithSameRowOrColumn solver = new P0947MostStonesRemovedWithSameRowOrColumn();
        assertEquals(5, solver.removeStones(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}}));
        assertEquals(3, solver.removeStones(new int[][]{{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}}));
        assertEquals(0, solver.removeStones(new int[][]{{0, 0}}));
    }
}
