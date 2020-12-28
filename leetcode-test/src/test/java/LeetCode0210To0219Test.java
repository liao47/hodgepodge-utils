import com.github.liao47.leetcode.P0217ContainsDuplicate;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author liao47
 * @date 2020/12/17 13:54
 */
public class LeetCode0210To0219Test {
    @Test
    public void test0217() {
        P0217ContainsDuplicate solver = new P0217ContainsDuplicate();

        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        long start = System.currentTimeMillis();

        assertTrue(solver.containsDuplicate(new int[]{1, 2, 3, 1}));
        assertFalse(solver.containsDuplicate(new int[]{1, 2, 3, 4}));
        assertTrue(solver.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
        assertFalse(solver.containsDuplicate(arr));

        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();

        assertTrue(solver.containsDuplicate2(new int[]{1, 2, 3, 1}));
        assertFalse(solver.containsDuplicate2(new int[]{1, 2, 3, 4}));
        assertTrue(solver.containsDuplicate2(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
        assertFalse(solver.containsDuplicate2(arr));

        System.out.println(System.currentTimeMillis() - start);
    }
}
