import com.github.liao47.leetcode.I0101IsUniquelcci;
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
}
