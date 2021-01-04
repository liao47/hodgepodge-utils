import com.github.liao47.leetcode.P1046LastStoneWeight;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2020/12/30 15:30
 */
public class LeetCode1040To1049Test {
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
