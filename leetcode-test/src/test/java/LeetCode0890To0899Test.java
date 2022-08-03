import com.github.liao47.leetcode.P0895MaximumFrequencyStack;
import com.github.liao47.leetcode.P0899OrderlyQueue;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2020/12/11 14:45
 */
public class LeetCode0890To0899Test {
    @Test
    public void test0895() {
        P0895MaximumFrequencyStack.FreqStack freqStack = new P0895MaximumFrequencyStack.FreqStack();
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


        P0895MaximumFrequencyStack.FreqStack2 freqStack2 = new P0895MaximumFrequencyStack.FreqStack2();
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

    @Test
    public void test0899() {
        P0899OrderlyQueue solver = new P0899OrderlyQueue();
        Assert.assertEquals("acb", solver.orderlyQueue("cba", 1));
        Assert.assertEquals("aaabc", solver.orderlyQueue("baaca", 3));
        Assert.assertEquals("gvxz", solver.orderlyQueue("gxzv", 4));
        Assert.assertEquals("cikk", solver.orderlyQueue("kikc", 3));
        Assert.assertEquals("imvxz", solver.orderlyQueue("xmvzi", 2));
    }
}
