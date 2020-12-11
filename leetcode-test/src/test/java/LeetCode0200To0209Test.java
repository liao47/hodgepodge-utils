import com.github.liao47.leetcode.LeetCode0204;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2020/12/3 16:43
 */
public class LeetCode0200To0209Test {

    @Test
    public void test204() {
        LeetCode0204 solver = new LeetCode0204();
        assertEquals(4, solver.countPrimes(10));
        assertEquals(0, solver.countPrimes(0));
        assertEquals(0, solver.countPrimes(1));
        assertEquals(0, solver.countPrimes(2));
    }
}
