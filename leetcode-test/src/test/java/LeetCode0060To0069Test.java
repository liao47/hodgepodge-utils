import com.github.liao47.leetcode.P0062UniquePaths;
import com.github.liao47.leetcode.P0066PlusOne;
import com.github.liao47.leetcode.P0068TextJustification;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2020/12/10 15:13
 */
public class LeetCode0060To0069Test {

    @Test
    public void test0062() {
        P0062UniquePaths solver = new P0062UniquePaths();

        assertEquals(28, solver.uniquePaths(3, 7));
        assertEquals(3, solver.uniquePaths(3, 2));
        assertEquals(28, solver.uniquePaths(7, 3));
        assertEquals(6, solver.uniquePaths(3, 3));
        assertEquals(193536720, solver.uniquePaths(23, 12));
    }

    @Test
    public void test0066() {
        P0066PlusOne solver = new P0066PlusOne();
        assertArrayEquals(new int[]{1, 2, 4}, solver.plusOne(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{4, 3, 2, 2}, solver.plusOne(new int[]{4, 3, 2, 1}));
        assertArrayEquals(new int[]{1}, solver.plusOne(new int[]{0}));
        assertArrayEquals(new int[]{1, 0}, solver.plusOne(new int[]{9}));
    }

    @Test
    public void test0068() {
        P0068TextJustification solver = new P0068TextJustification();
        List<String> ans;

        ans = solver.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
        System.out.println(ans);
        Assert.assertFalse(ans.retainAll(Arrays.asList("This    is    an", "example  of text", "justification.  ")));

        ans = solver.fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16);
        System.out.println(ans);
        Assert.assertFalse(ans.retainAll(Arrays.asList("What   must   be", "acknowledgment  ", "shall be        ")));

        ans = solver.fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to",
                "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20);
        Assert.assertFalse(ans.retainAll(Arrays.asList("Science  is  what we", "understand      well",
                "enough to explain to", "a  computer.  Art is", "everything  else  we", "do                  ")));

        ans = solver.fullJustify(new String[]{"Listen", "to", "many,", "speak", "to", "a", "few."}, 6);
        System.out.println(ans);
        Assert.assertFalse(ans.retainAll(Arrays.asList("Listen","to    ","many, ","speak ","to   a","few.  ")));

        ans = solver.fullJustify(new String[]{"Give", "me", "my", "Romeo;", "and,", "when", "he", "shall", "die,",
                "Take", "him", "and", "cut", "him", "out", "in", "little", "stars,", "And", "he", "will", "make",
                "the", "face", "of", "heaven", "so", "fine", "That", "all", "the", "world", "will", "be", "in", "love"
                , "with", "night", "And", "pay", "no", "worship", "to", "the", "garish", "sun."}, 25);
        Assert.assertFalse(ans.retainAll(Arrays.asList("Give  me  my  Romeo; and,", "when  he  shall die, Take",
                "him  and  cut  him out in", "little stars, And he will", "make  the  face of heaven",
                "so   fine  That  all  the", "world  will  be  in  love", "with  night  And  pay  no",
                "worship   to  the  garish", "sun.                     ")));
    }
}
