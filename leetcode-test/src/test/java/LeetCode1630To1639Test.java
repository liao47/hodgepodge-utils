import com.github.liao47.leetcode.P1636SortArrayByIncreasingFrequency;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author liaoshiqing
 * @date 2022/9/19 9:37
 */
public class LeetCode1630To1639Test {
    @Test
    public void test1636() {
        P1636SortArrayByIncreasingFrequency solver = new P1636SortArrayByIncreasingFrequency();
        Assert.assertArrayEquals(new int[]{3, 1, 1, 2, 2, 2}, solver.frequencySort(new int[]{1, 1, 2, 2, 2, 3}));
        Assert.assertArrayEquals(new int[]{1, 3, 3, 2, 2}, solver.frequencySort(new int[]{2, 3, 1, 3, 2}));
        Assert.assertArrayEquals(new int[]{5, -1, 4, 4, -6, -6, 1, 1, 1}, solver.frequencySort(new int[]{-1, 1, -6, 4
                , 5, -6, 1, 4, 1}));
        Assert.assertArrayEquals(new int[]{79, 79, -46, -46, -60, -60, -100, -100, 55, 55, 55, 21, 21, 21, -50, -50,
                -50, -79, -79, -79, 100, 100, 100, 100, -13, -13, -13, -13, -51, -51, -51, -51, -65, -65, -65, -65,
                68, 68, 68, 68, 68, 30, 30, 30, 30, 30, 40, 40, 40, 40, 40, 40}, solver.frequencySort(new int[]{-79,
                40, 21, 40, 30, -100, -50, -79, -51, 30, -65, -13, -46, 100, 40, -65, -13, 100, 40, -79, 55, 68, 55,
                68, 68, 30, 79, -51, 68, 21, -60, 40, 79, 30, 55, -65, -13, -46, -100, -50, 21, -60, -51, 100, -51, -50, 30, 100, 40, 68, -13, -65}));
    }
}
