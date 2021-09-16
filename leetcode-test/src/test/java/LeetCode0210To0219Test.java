import com.github.liao47.leetcode.P0212WordSearchII;
import com.github.liao47.leetcode.P0217ContainsDuplicate;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author liao47
 * @date 2020/12/17 13:54
 */
public class LeetCode0210To0219Test {
    @Test
    public void test0212() {
        P0212WordSearchII solver = new P0212WordSearchII();
        Assert.assertTrue(Arrays.asList("eat","oath").containsAll(solver.findWords(new char[][]{{'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}},
                new String[]{"oath", "pea", "eat", "rain"})));
        Assert.assertTrue(solver.findWords(new char[][]{{'a','b'}, {'c','d'}}, new String[]{"abcb"}).isEmpty());
        Assert.assertTrue(solver.findWords(new char[][]{{'o', 'a', 'a', 'n'},
                        {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}},
                new String[]{"oateoaan", "pea", "rain"}).isEmpty());
    }

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
