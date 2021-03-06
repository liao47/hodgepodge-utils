import com.github.liao47.leetcode.P0738MonotoneIncreasingDigits;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2020/12/15 10:14
 */
public class LeetCode0730To0739Test {
    @Test
    public void test0738() {
        P0738MonotoneIncreasingDigits solver = new P0738MonotoneIncreasingDigits();

        assertEquals(9, solver.monotoneIncreasingDigits(10));
        assertEquals(1234, solver.monotoneIncreasingDigits(1234));
        assertEquals(299, solver.monotoneIncreasingDigits(332));
        assertEquals(99, solver.monotoneIncreasingDigits(100));

        assertEquals(9, solver.monotoneIncreasingDigits2(10));
        assertEquals(1234, solver.monotoneIncreasingDigits2(1234));
        assertEquals(299, solver.monotoneIncreasingDigits2(332));
        assertEquals(99, solver.monotoneIncreasingDigits2(100));

        assertEquals(9, solver.monotoneIncreasingDigits3(10));
        assertEquals(1234, solver.monotoneIncreasingDigits3(1234));
        assertEquals(299, solver.monotoneIncreasingDigits3(332));
        assertEquals(99, solver.monotoneIncreasingDigits3(100));
    }
}
