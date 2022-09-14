import com.github.liao47.leetcode.P0290WordPattern;
import com.github.liao47.leetcode.P0295FindMedianFromDataStream;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author liaoshiqing
 * @date 2020/12/16 15:07
 */
public class LeetCode0290To0299Test {
    @Test
    public void test0290() {
        P0290WordPattern solver = new P0290WordPattern();

        assertTrue(solver.wordPattern("abba", "dog cat cat dog"));
        assertFalse(solver.wordPattern("abba", "dog cat cat fish"));
        assertFalse(solver.wordPattern("aaaa", "dog cat cat dog"));
        assertFalse(solver.wordPattern("abba", "dog dog dog dog"));
        assertTrue(solver.wordPattern("abc", "b c a"));

        assertTrue(solver.wordPattern2("abba", "dog cat cat dog"));
        assertFalse(solver.wordPattern2("abba", "dog cat cat fish"));
        assertFalse(solver.wordPattern2("aaaa", "dog cat cat dog"));
        assertFalse(solver.wordPattern2("abba", "dog dog dog dog"));
        assertTrue(solver.wordPattern2("abc", "b c a"));
        assertFalse(solver.wordPattern2("abc", "dog cat dog"));
    }

    @Test
    public void test0295() {
        P0295FindMedianFromDataStream.MedianFinder medianFinder = new P0295FindMedianFromDataStream.MedianFinder();
        medianFinder.addNum(40);
        medianFinder.addNum(12);
        medianFinder.addNum(16);
        Assert.assertEquals(16, medianFinder.findMedian(), 0.01);

        medianFinder = new P0295FindMedianFromDataStream.MedianFinder();
        medianFinder.addNum(1);
        Assert.assertEquals(1, medianFinder.findMedian(), 0.01);
        medianFinder.addNum(2);
        Assert.assertEquals(1.5, medianFinder.findMedian(), 0.01);
        medianFinder.addNum(3);
        Assert.assertEquals(2, medianFinder.findMedian(), 0.01);
        medianFinder.addNum(4);
        Assert.assertEquals(2.5, medianFinder.findMedian(), 0.01);
        medianFinder.addNum(5);
        Assert.assertEquals(3, medianFinder.findMedian(), 0.01);

        medianFinder = new P0295FindMedianFromDataStream.MedianFinder();
        medianFinder.addNum(-1);
        Assert.assertEquals(-1, medianFinder.findMedian(), 0.01);
        medianFinder.addNum(-2);
        Assert.assertEquals(-1.5, medianFinder.findMedian(), 0.01);
        medianFinder.addNum(-3);
        Assert.assertEquals(-2, medianFinder.findMedian(), 0.01);
        medianFinder.addNum(-4);
        Assert.assertEquals(-2.5, medianFinder.findMedian(), 0.01);
        medianFinder.addNum(-5);
        Assert.assertEquals(-3, medianFinder.findMedian(), 0.01);
    }
}
