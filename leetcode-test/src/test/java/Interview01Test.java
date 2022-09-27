import com.github.liao47.leetcode.I0101IsUniquelcci;
import com.github.liao47.leetcode.I0102CheckPermutationLcci;
import org.junit.Assert;
import org.junit.Test;

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
}
