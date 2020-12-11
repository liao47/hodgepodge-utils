import com.github.liao47.leetcode.LeetCode0006;
import com.github.liao47.leetcode.LeetCode0007;
import com.github.liao47.leetcode.LeetCode0008;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2020/12/3 16:43
 */
public class LeetCode0001To0009Test {

    @Test
    public void test0006() {
        LeetCode0006 solver = new LeetCode0006();
        assertEquals("LCIRETOESIIGEDHN", solver.convert("LEETCODEISHIRING", 3));
        assertEquals("LDREOEIIECIHNTSG", solver.convert("LEETCODEISHIRING", 4));
        assertEquals("AB", solver.convert("AB", 1));
    }

    @Test
    public void test0007() {
        LeetCode0007 solver = new LeetCode0007();
        System.out.println(solver.reverse(123));
        System.out.println(solver.reverse(789));
        assertEquals(987654321, solver.reverse(1234567890));
    }

    @Test
    public void test0008() {
        LeetCode0008 solver = new LeetCode0008();
        assertEquals(42, solver.myAtoi("42"));
        assertEquals(-42, solver.myAtoi("   -42"));
        assertEquals(4193, solver.myAtoi("4193 with words"));
        assertEquals(0, solver.myAtoi("words and 987"));
        assertEquals(Integer.MIN_VALUE, solver.myAtoi("-91283472332"));
        assertEquals(Integer.MAX_VALUE, solver.myAtoi("9223372036854775808"));
        assertEquals(0, solver.myAtoi(" "));
    }
}
