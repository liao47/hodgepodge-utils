import com.github.liao47.leetcode.P1780CheckIfNumberIsASumOfPowersOfThree;
import com.github.liao47.leetcode.P1785MinimumElementsToAddToFormAGivenSum;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/12/9 10:08
 */
public class LeetCode1780To1789Test {
    @Test
    public void test1780() {
        P1780CheckIfNumberIsASumOfPowersOfThree solver = new P1780CheckIfNumberIsASumOfPowersOfThree();
        Assert.assertTrue(solver.checkPowersOfThree(12));
        Assert.assertTrue(solver.checkPowersOfThree(91));
        Assert.assertFalse(solver.checkPowersOfThree(21));
        Assert.assertFalse(solver.checkPowersOfThree(2));
        Assert.assertTrue(solver.checkPowersOfThree(6574365));
    }

    @Test
    public void test1785() {
        P1785MinimumElementsToAddToFormAGivenSum solver = new P1785MinimumElementsToAddToFormAGivenSum();
        Assert.assertEquals(2, solver.minElements(new int[]{1, -1, 1}, 3, -4));
        Assert.assertEquals(1, solver.minElements(new int[]{1, -10, 9, 1}, 100, 0));
    }
}
