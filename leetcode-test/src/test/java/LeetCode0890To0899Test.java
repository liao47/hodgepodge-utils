import com.github.liao47.leetcode.LeetCode0895;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2020/12/11 14:45
 */
public class LeetCode0890To0899Test {
    @Test
    public void test0895() {
        LeetCode0895.FreqStack freqStack = new LeetCode0895.FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        assertEquals(5, freqStack.pop());
        assertEquals(7, freqStack.pop());
        assertEquals(5, freqStack.pop());
        assertEquals(4, freqStack.pop());


        LeetCode0895.FreqStack2 freqStack2 = new LeetCode0895.FreqStack2();
        freqStack2.push(5);
        freqStack2.push(7);
        freqStack2.push(5);
        freqStack2.push(7);
        freqStack2.push(4);
        freqStack2.push(5);
        assertEquals(5, freqStack2.pop());
        assertEquals(7, freqStack2.pop());
        assertEquals(5, freqStack2.pop());
        assertEquals(4, freqStack2.pop());
    }
}
