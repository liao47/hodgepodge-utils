import com.github.liao47.leetcode.P0316RemoveDuplicateLetters;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author liaoshiqing
 * @date 2020/12/22 11:15
 */
public class LeetCode0310To0319Test {
    @Test
    public void test0316() {
        P0316RemoveDuplicateLetters solver = new P0316RemoveDuplicateLetters();
        assertEquals("abc", solver.removeDuplicateLetters("bcabc"));
        assertEquals("acdb", solver.removeDuplicateLetters("cbacdcbc"));
    }
}
