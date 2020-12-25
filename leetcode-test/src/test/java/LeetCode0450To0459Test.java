import com.github.liao47.leetcode.P0455AssignCookies;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author liaoshiqing
 * @date 2020/12/25 10:47
 */
public class LeetCode0450To0459Test {
    @Test
    public void test0455() {
        P0455AssignCookies solver = new P0455AssignCookies();
        assertEquals(1, solver.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        assertEquals(2, solver.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
        assertEquals(2, solver.findContentChildren(new int[]{2, 3, 4}, new int[]{1, 3, 3}));
    }
}
