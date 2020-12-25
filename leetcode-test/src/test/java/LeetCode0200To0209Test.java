import com.github.liao47.leetcode.P0204CountPrimes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2020/12/3 16:43
 */
public class LeetCode0200To0209Test {

    @Test
    public void test204() {
        P0204CountPrimes solver = new P0204CountPrimes();
        assertEquals(4, solver.countPrimes(10));
        assertEquals(0, solver.countPrimes(0));
        assertEquals(0, solver.countPrimes(1));
        assertEquals(0, solver.countPrimes(2));
    }
}
