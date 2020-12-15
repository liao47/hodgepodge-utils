import com.github.liao47.leetcode.LeetCode0483;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2020/12/15 13:56
 */
public class LeetCode0481To0489Test {
    @Test
    public void test0483() {
        LeetCode0483 solver = new LeetCode0483();
        long start = System.currentTimeMillis();

        assertEquals("3", solver.smallestGoodBase("13"));
        assertEquals("8", solver.smallestGoodBase("4681"));
        assertEquals("999999999999999999", solver.smallestGoodBase("1000000000000000000"));
        assertEquals("999999999999999999", solver.smallestGoodBase("1000000000000000000"));

        System.out.println(System.currentTimeMillis() - start);
    }
}
