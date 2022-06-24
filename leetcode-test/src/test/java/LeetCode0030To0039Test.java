import com.github.liao47.leetcode.P0030SubstringWithConcatenationOfAllWords;
import com.github.liao47.leetcode.P0034FindFirstAndLastPositionOfElementInSortedArray;
import com.github.liao47.leetcode.P0036ValidSudoku;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author liaoshiqing
 * @date 2021/7/23 14:23
 */
public class LeetCode0030To0039Test {
    @Test
    public void test0030() {
        P0030SubstringWithConcatenationOfAllWords solver = new P0030SubstringWithConcatenationOfAllWords();
        String[] words = new String[]{"foo", "bar"};
        Assert.assertEquals(Arrays.asList(0, 9), solver.findSubstring("barfoothefoobarman", words));

        words = new String[]{"word", "good", "best", "word"};
        Assert.assertTrue(solver.findSubstring("wordgoodgoodgoodbestword", words).isEmpty());

        words = new String[]{"bar", "foo", "the"};
        Assert.assertEquals(Arrays.asList(6, 9, 12), solver.findSubstring("barfoofoobarthefoobarman", words));

        words = new String[]{"to", "to", "to"};
        Assert.assertEquals(Arrays.asList(2, 4, 6), solver.findSubstring("ottototototo", words));
    }

    @Test
    public void test0034() {
        P0034FindFirstAndLastPositionOfElementInSortedArray solver =
                new P0034FindFirstAndLastPositionOfElementInSortedArray();
        Assert.assertArrayEquals(new int[]{3, 4}, solver.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
        Assert.assertArrayEquals(new int[]{-1, -1}, solver.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
        Assert.assertArrayEquals(new int[]{-1, -1}, solver.searchRange(new int[]{}, 0));
        Assert.assertArrayEquals(new int[]{0, 0}, solver.searchRange(new int[]{1}, 1));
        Assert.assertArrayEquals(new int[]{1, 5}, solver.searchRange(new int[]{1, 2, 2, 2, 2, 2, 3}, 2));

        Assert.assertEquals(2, solver.search(new int[]{5, 7, 7, 8, 8, 10}, 8));
        Assert.assertEquals(0, solver.search(new int[]{5, 7, 7, 8, 8, 10}, 6));
    }

    @Test
    public void test0036() {
        P0036ValidSudoku solver = new P0036ValidSudoku();
        Assert.assertTrue(solver.isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}));
        Assert.assertFalse(solver.isValidSudoku(new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}));
        Assert.assertFalse(solver.isValidSudoku(new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'2', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}));
    }
}
