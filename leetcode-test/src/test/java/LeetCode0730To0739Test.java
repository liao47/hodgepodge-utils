import com.github.liao47.leetcode.P0731MyCalendarII;
import com.github.liao47.leetcode.P0735AsteroidCollision;
import com.github.liao47.leetcode.P0738MonotoneIncreasingDigits;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2020/12/15 10:14
 */
public class LeetCode0730To0739Test {
    @Test
    public void test0731() {
        P0731MyCalendarII.MyCalendarTwo myCalendarTwo = new P0731MyCalendarII.MyCalendarTwo();
        Assert.assertTrue(myCalendarTwo.book(10, 20));
        Assert.assertTrue(myCalendarTwo.book(50, 60));
        Assert.assertTrue(myCalendarTwo.book(10, 40));
        Assert.assertFalse(myCalendarTwo.book(5, 15));
        Assert.assertTrue(myCalendarTwo.book(5, 10));
        Assert.assertTrue(myCalendarTwo.book(25, 55));
        Assert.assertFalse(myCalendarTwo.book(20, 40));
        Assert.assertFalse(myCalendarTwo.book(30, 35));
    }

    @Test
    public void test0735() {
        P0735AsteroidCollision solver = new P0735AsteroidCollision();
        Assert.assertArrayEquals(new int[]{5, 10}, solver.asteroidCollision(new int[]{5, 10, -5}));
        Assert.assertArrayEquals(new int[0], solver.asteroidCollision(new int[]{8, -8}));
        Assert.assertArrayEquals(new int[]{-2, -1, 1, 2}, solver.asteroidCollision(new int[]{-2, -1, 1, 2}));
        Assert.assertArrayEquals(new int[]{-2, -2, -2}, solver.asteroidCollision(new int[]{-2, -2, 1, -2}));
        Assert.assertArrayEquals(new int[]{-2, -2, -2}, solver.asteroidCollision(new int[]{1, -2, -2, -2}));
    }

    @Test
    public void test0738() {
        P0738MonotoneIncreasingDigits solver = new P0738MonotoneIncreasingDigits();

        assertEquals(9, solver.monotoneIncreasingDigits(10));
        assertEquals(1234, solver.monotoneIncreasingDigits(1234));
        assertEquals(299, solver.monotoneIncreasingDigits(332));
        assertEquals(99, solver.monotoneIncreasingDigits(100));

        assertEquals(9, solver.monotoneIncreasingDigits2(10));
        assertEquals(1234, solver.monotoneIncreasingDigits2(1234));
        assertEquals(299, solver.monotoneIncreasingDigits2(332));
        assertEquals(99, solver.monotoneIncreasingDigits2(100));

        assertEquals(9, solver.monotoneIncreasingDigits3(10));
        assertEquals(1234, solver.monotoneIncreasingDigits3(1234));
        assertEquals(299, solver.monotoneIncreasingDigits3(332));
        assertEquals(99, solver.monotoneIncreasingDigits3(100));
    }
}
