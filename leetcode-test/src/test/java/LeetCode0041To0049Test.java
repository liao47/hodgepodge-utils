import com.github.liao47.leetcode.LeetCode0049;
import com.github.liao47.leetcode.T0048RotateImage;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2020/12/14 16:07
 */
public class LeetCode0041To0049Test {
    @Test
    public void test0048() {
        T0048RotateImage solver = new T0048RotateImage();

        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        solver.rotate(arr);
        assertEquals("[[7, 4, 1], [8, 5, 2], [9, 6, 3]]", Arrays.deepToString(arr));

        arr = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        solver.rotate(arr);
        assertEquals("[[15, 13, 2, 5], [14, 3, 4, 1], [12, 6, 8, 9], [16, 7, 10, 11]]", Arrays.deepToString(arr));

        arr = new int[][]{
                {5, 1, 9, 11, 17},
                {2, 4, 8, 10, 18},
                {13, 3, 6, 7, 19},
                {15, 14, 12, 16, 20},
                {21, 22, 23, 24, 25}
        };
        solver.rotate(arr);
        assertEquals("[[21, 15, 13, 2, 5], [22, 14, 3, 4, 1], [23, 12, 6, 8, 9], [24, 16, 7, 10, 11], [25, 20, 19, " +
                "18, 17]]", Arrays.deepToString(arr));
    }

    @Test
    public void test0049() {
        LeetCode0049 solver = new LeetCode0049();

        String[] strArr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solver.groupAnagrams(strArr));
        System.out.println(solver.groupAnagrams2(strArr));

        strArr = new String[]{"ddddddddddg", "dgggggggggg"};
        System.out.println(solver.groupAnagrams(strArr));
        System.out.println(solver.groupAnagrams2(strArr));

        strArr = new String[]{"aaabb", "aabbb"};
        System.out.println(solver.groupAnagrams(strArr));
        System.out.println(solver.groupAnagrams2(strArr));
    }
}
