import com.github.liao47.leetcode.P0547NumberOfProvinces;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2021/1/7 14:16
 */
public class LeetCode0540To0549Test {
    @Test
    public void test0547() {
        P0547NumberOfProvinces solver = new P0547NumberOfProvinces();
        assertEquals(2, solver.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        assertEquals(3, solver.findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
        assertEquals(1, solver.findCircleNum(new int[][]{{1, 0, 1, 0, 1}, {0, 1, 0, 1, 1}, {1, 0, 1, 0, 0},
                {0, 1, 0, 1, 0}, {1, 1, 0, 0, 1}}));
        assertEquals(2, solver.findCircleNum(new int[][]{{1, 0, 1, 0, 0}, {0, 1, 0, 1, 1}, {1, 0, 1, 0, 0},
                {0, 1, 0, 1, 0}, {0, 1, 0, 0, 1}}));
    }
}
