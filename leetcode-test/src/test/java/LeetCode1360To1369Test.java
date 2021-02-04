import com.github.liao47.leetcode.P1362ClosestDivisors;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author liao47
 * @date 2021/1/7 16:09
 */
public class LeetCode1360To1369Test {
    @Test
    public void test1362() {
        P1362ClosestDivisors solver = new P1362ClosestDivisors();
        assertArrayEquals(new int[]{3, 3}, solver.closestDivisors(8));
        assertArrayEquals(new int[]{5, 25}, solver.closestDivisors(123));
        assertArrayEquals(new int[]{25, 40}, solver.closestDivisors(999));
        assertArrayEquals(new int[]{1, 2}, solver.closestDivisors(1));
        assertArrayEquals(new int[]{42966, 49981}, solver.closestDivisors(Integer.MAX_VALUE - 2));
    }
}
