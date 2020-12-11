import com.github.liao47.leetcode.LeetCode0118;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2020/12/11 13:56
 */
public class LeetCode0110To0119Test {
    @Test
    public void test0118() {
        LeetCode0118 solver = new LeetCode0118();

        assertEquals("[[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]", solver.generate(5).toString());
    }
}
