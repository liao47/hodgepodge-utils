import com.github.liao47.leetcode.P1619MeanOfArrayAfterRemovingSomeElements;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/9/14 13:47
 */
public class LeetCode1610To1619Test {
    @Test
    public void test1619() {
        P1619MeanOfArrayAfterRemovingSomeElements solver = new P1619MeanOfArrayAfterRemovingSomeElements();
        int[] arr = new int[]{1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
        Assert.assertEquals(2.0, solver.trimMean(arr), 0.00001);
        arr = new int[]{6, 2, 7, 5, 1, 2, 0, 3, 10, 2, 5, 0, 5, 5, 0, 8, 7, 6, 8, 0};
        Assert.assertEquals(4.0, solver.trimMean(arr), 0.00001);
        arr = new int[]{6, 0, 7, 0, 7, 5, 7, 8, 3, 4, 0, 7, 8, 1, 6, 8, 1, 1, 2, 4, 8, 1, 9, 5, 4, 3, 8, 5, 10, 8, 6, 6, 1, 0, 6, 10, 8, 2, 3, 4};
        Assert.assertEquals(4.77778, solver.trimMean(arr), 0.00001);
    }
}
