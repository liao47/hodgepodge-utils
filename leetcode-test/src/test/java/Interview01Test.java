import com.github.liao47.leetcode.I0101IsUniquelcci;
import com.github.liao47.leetcode.I0102CheckPermutationLcci;
import com.github.liao47.leetcode.I0108ZeroMatrixLcci;
import com.github.liao47.leetcode.I0109StringRotationLcci;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author liao47
 * @date 2020/12/18 14:38
 */
public class Interview01Test {

    @Test
    public void test0101() {
        I0101IsUniquelcci solver = new I0101IsUniquelcci();
        assertFalse(solver.isUnique("leetcode"));
        assertTrue(solver.isUnique("abc"));
    }

    @Test
    public void test0102() {
        I0102CheckPermutationLcci solver = new I0102CheckPermutationLcci();
        Assert.assertTrue(solver.CheckPermutation("abc", "bca"));
        Assert.assertFalse(solver.CheckPermutation("abc", "bad"));
    }

    @Test
    public void test0108() {
        I0108ZeroMatrixLcci solver = new I0108ZeroMatrixLcci();
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] answer = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        solver.setZeroes(matrix);
        Assert.assertArrayEquals(answer, matrix);

        matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        answer = new int[][]{{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}};
        solver.setZeroes(matrix);
        Assert.assertArrayEquals(answer, matrix);
    }

    @Test
    public void test0109() {
        I0109StringRotationLcci solver = new I0109StringRotationLcci();
        Assert.assertTrue(solver.isFlipedString("waterbottle", "erbottlewat"));
        Assert.assertFalse(solver.isFlipedString("aa", "aba"));
        Assert.assertTrue(solver.isFlipedString("aaa", "aaa"));
        Assert.assertTrue(solver.isFlipedString("aba", "aab"));
        Assert.assertTrue(solver.isFlipedString("", ""));
        Assert.assertFalse(solver.isFlipedString("aba", "bab"));
    }
}
