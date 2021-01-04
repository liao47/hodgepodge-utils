import com.github.liao47.leetcode.P0509FibonacciNumber;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2021/1/4 10:00
 */
public class LeetCode0500To0509Test {
    @Test
    public void test0509() {
        P0509FibonacciNumber solver = new P0509FibonacciNumber();
        assertEquals(1, solver.fib(2));
        assertEquals(2, solver.fib(3));
        assertEquals(3, solver.fib(4));
    }
}
