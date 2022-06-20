import com.github.liao47.leetcode.P1089DuplicateZeros;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/6/17 15:43
 */
public class LeetCode1080To1089Test {

    @Test
    public void test1089() {
        P1089DuplicateZeros solver = new P1089DuplicateZeros();
        int[] arr = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        solver.duplicateZeros(arr);
        Assert.assertArrayEquals(arr, new int[]{1, 0, 0, 2, 3, 0, 0, 4});

        arr = new int[]{1, 0, 0, 1, 2, 3};
        solver.duplicateZeros(arr);
        Assert.assertArrayEquals(arr, new int[]{1, 0, 0, 0, 0, 1});

        arr = new int[]{8, 4, 5, 0, 0, 0, 0, 7};
        solver.duplicateZeros(arr);
        Assert.assertArrayEquals(arr, new int[]{8, 4, 5, 0, 0, 0, 0, 0});
    }
}
