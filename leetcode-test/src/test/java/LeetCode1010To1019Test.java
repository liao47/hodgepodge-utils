import com.github.liao47.leetcode.P1015SmallestIntegerDivisibleByK;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2020/12/22 15:50
 */
public class LeetCode1010To1019Test {
    @Test
    public void test1015() {
        P1015SmallestIntegerDivisibleByK solver = new P1015SmallestIntegerDivisibleByK();
        assertEquals(1, solver.smallestRepunitDivByK(1));
        assertEquals(-1, solver.smallestRepunitDivByK(2));
        assertEquals(3, solver.smallestRepunitDivByK(3));
        assertEquals(6, solver.smallestRepunitDivByK(7));
        assertEquals(9, solver.smallestRepunitDivByK(9));
    }
}
