import com.github.liao47.leetcode.Interview0101;
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
        Interview0101 solver = new Interview0101();
        assertFalse(solver.isUnique("leetcode"));
        assertTrue(solver.isUnique("abc"));
    }
}
