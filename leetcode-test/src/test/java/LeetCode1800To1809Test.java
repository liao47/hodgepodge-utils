import com.github.liao47.leetcode.P1802MaximumValueAtAGivenIndexInABoundedArray;
import com.github.liao47.leetcode.P1805NumberOfDifferentIntegersInAString;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/12/9 16:34
 */
public class LeetCode1800To1809Test {
    @Test
    public void test1802() {
        P1802MaximumValueAtAGivenIndexInABoundedArray solver = new P1802MaximumValueAtAGivenIndexInABoundedArray();
        Assert.assertEquals(2, solver.maxValue(4, 2, 6));
        Assert.assertEquals(3, solver.maxValue(6, 1, 10));
        Assert.assertEquals(7, solver.maxValue(3, 2, 18));
        Assert.assertEquals(1, solver.maxValue(4, 0, 4));
        Assert.assertEquals(271698267, solver.maxValue(3, 0, 815094800));
    }

    @Test
    public void test1805() {
        P1805NumberOfDifferentIntegersInAString solver = new P1805NumberOfDifferentIntegersInAString();
        Assert.assertEquals(3, solver.numDifferentIntegers("a123bc34d8ef34"));
        Assert.assertEquals(2, solver.numDifferentIntegers("leet1234code234"));
        Assert.assertEquals(1, solver.numDifferentIntegers("a1b01c001"));
        Assert.assertEquals(4, solver.numDifferentIntegers("a000aa11bc34d8ef34c00"));
        Assert.assertEquals(2, solver.numDifferentIntegers("035985750011523523129774573439111590559325a1554234973"));
    }
}
