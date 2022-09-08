import com.github.liao47.leetcode.P0667BeautifulArrangementII;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liaoshiqing
 * @date 2022/9/8 14:28
 */
public class LeetCode0660To0669Test {
    @Test
    public void test0667() {
        P0667BeautifulArrangementII solver = new P0667BeautifulArrangementII();
        assert0667(solver, 3, 1);
        assert0667(solver, 3, 2);
        assert0667(solver, 5, 4);
        assert0667(solver, 5, 3);
        assert0667(solver, 5, 2);
        assert0667(solver, 5, 1);
        assert0667(solver, 6, 5);
        assert0667(solver, 6, 4);
        assert0667(solver, 6, 3);
    }

    private void assert0667(P0667BeautifulArrangementII solver, int n, int k) {
        int[] arr = solver.constructArray(n, k);
        Assert.assertEquals(n, arr.length);

        int[] count = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            Assert.assertTrue(0 < arr[i] && arr[i] <= n && ++count[arr[i] - 1] == 1);
            if (i != 0) {
                set.add(Math.abs(arr[i] - arr[i - 1]));
            }
        }
        Assert.assertEquals(k, set.size());
    }
}
