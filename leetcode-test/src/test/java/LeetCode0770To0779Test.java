import com.github.liao47.leetcode.P0777SwapAdjacentInLrString;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/10/12 16:20
 */
public class LeetCode0770To0779Test {
    @Test
    public void tet0777() {
        P0777SwapAdjacentInLrString solver = new P0777SwapAdjacentInLrString();
        Assert.assertTrue(solver.canTransform("RXXLRXRXL", "XRLXXRRLX"));
        Assert.assertFalse(solver.canTransform("XXRXXLXXXX", "XXXXRXXLXX"));
        Assert.assertFalse(solver.canTransform("LXXLXRLXXL", "XLLXRXLXLX"));
    }
}
