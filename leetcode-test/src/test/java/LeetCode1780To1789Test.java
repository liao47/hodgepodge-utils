import com.github.liao47.leetcode.P1780CheckIfNumberIsASumOfPowersOfThree;
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
}
