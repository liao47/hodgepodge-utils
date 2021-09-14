import com.github.liao47.leetcode.P0524LongestWordInDictionaryThroughDeleting;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author liaoshiqing
 * @date 2021/9/14 9:26
 */
public class LeetCode0520To0529Test {
    @Test
    public void test0524() {
        P0524LongestWordInDictionaryThroughDeleting solver = new P0524LongestWordInDictionaryThroughDeleting();
        Assert.assertEquals("apple", solver.findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")));
        Assert.assertEquals("a", solver.findLongestWord("abpcplea", Arrays.asList("a", "b", "c")));
        Assert.assertEquals("bpc", solver.findLongestWord("abpcplea", Arrays.asList("cpl", "bpc", "ab")));
        Assert.assertEquals("apple", solver.findLongestWord("abpcplea", Arrays.asList("ale","apple","monkey","plea", "abpcplaaa","abpcllllll","abccclllpppeeaaaa")));
    }
}
