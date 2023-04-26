import com.github.liao47.leetcode.P1031;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2023/4/26 13:52
 */
public class LeetCode1030To1039Test {
    @Test
    public void test1031() {
        P1031 solver = new P1031();
        Assert.assertEquals(20, solver.maxSumTwoNoOverlap(new int[]{0, 6, 5, 2, 2, 5, 1, 9, 4}, 1, 2));
        Assert.assertEquals(29, solver.maxSumTwoNoOverlap(new int[]{3, 8, 1, 3, 2, 1, 8, 9, 0}, 3, 2));
        Assert.assertEquals(31, solver.maxSumTwoNoOverlap(new int[]{2, 1, 5, 6, 0, 9, 5, 0, 3, 8}, 4, 3));
    }
}
