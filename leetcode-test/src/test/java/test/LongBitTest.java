package test;

import com.github.liao47.leetcode.utils.LongBit;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/7/18 10:53
 */
public class LongBitTest {
    @Test
    public void test() {
        LongBit longBit = LongBit.of(200);
        longBit.or(128).or(256).or(100);
        Assert.assertEquals(128, longBit.indexOfHighest());
        Assert.assertEquals(100, longBit.indexOfLowest());
        longBit.or(156).or(64).or(32);
        Assert.assertEquals(156, longBit.indexOfHighest());
        Assert.assertEquals(32, longBit.indexOfLowest());
        Assert.assertTrue(longBit.contains(128));
        Assert.assertTrue(longBit.contains(100));
        Assert.assertFalse(longBit.contains(255));
        LongBit and = LongBit.of(128).or(32).or(64).or(100).or(78).and(longBit);
        Assert.assertEquals(32, and.indexOfLowest());
        Assert.assertEquals(100, and.indexOfHighest());
        Assert.assertTrue(LongBit.of(60).or(18).or(and).contains(100));
    }
}
