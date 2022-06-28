import com.github.liao47.leetcode.P0324WiggleSortII;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author liaoshiqing
 * @date 2022/6/28 9:42
 */
public class LeetCode0320To0329Test {
    @Test
    public void test0324() {
        P0324WiggleSortII solver = new P0324WiggleSortII();
        int[] nums = new int[]{1, 5, 1, 1, 6, 4};
        solver.wiggleSort(nums);
        assertTest0324(nums);

        nums = new int[]{1, 3, 2, 2, 3, 1};
        solver.wiggleSort(nums);
        assertTest0324(nums);

        nums = new int[]{1, 1, 1, 4, 5, 6, 7};
        solver.wiggleSort(nums);
        assertTest0324(nums);
    }

    private void assertTest0324(int[] nums) {
        System.out.println(Arrays.toString(nums));
        int prev = Integer.MAX_VALUE;
        int flag = -1;
        for (int num : nums) {
            Assert.assertTrue((num - prev) * flag > 0);
            flag *= -1;
            prev = num;
        }
    }
}
