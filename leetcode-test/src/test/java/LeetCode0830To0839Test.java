import com.github.liao47.leetcode.P0830PositionsOfLargeGroups;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2021/1/6 10:48
 */
public class LeetCode0830To0839Test {
    @Test
    public void test0830() {
        P0830PositionsOfLargeGroups solver = new P0830PositionsOfLargeGroups();
        assertEquals("[[3, 6]]", solver.largeGroupPositions("abbxxxxzzy").toString());
        assertEquals("[]", solver.largeGroupPositions("abc").toString());
        assertEquals("[[3, 5], [6, 9], [12, 14]]", solver.largeGroupPositions("abcdddeeeeaabbbcd").toString());
        assertEquals("[]", solver.largeGroupPositions("aba").toString());
        assertEquals("[[0, 2]]", solver.largeGroupPositions("aaa").toString());
    }
}
