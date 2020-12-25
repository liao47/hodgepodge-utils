import com.github.liao47.leetcode.P0135Candy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author liaoshiqing
 * @date 2020/12/24 10:19
 */
public class LeetCode0130To0139Test {
    @Test
    public void test0135() {
        P0135Candy solver = new P0135Candy();
        assertEquals(5, solver.candy(new int[]{1, 0, 2}));
        assertEquals(4, solver.candy(new int[]{1, 2, 2}));
        assertEquals(16, solver.candy(new int[]{1, 2, 4, 3, 5, 6, 7}));
        assertEquals(14, solver.candy(new int[]{1, 7, 6, 3, 3, 4, 2, 1}));
        assertEquals(16, solver.candy(new int[]{1, 7, 6, 3, 3, 4, 4, 2, 1}));
        assertEquals(9, solver.candy(new int[]{1, 2, 3, 1, 0}));
    }
}
