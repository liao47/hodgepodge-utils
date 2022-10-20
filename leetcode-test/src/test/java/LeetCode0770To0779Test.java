import com.github.liao47.leetcode.P0777SwapAdjacentInLrString;
import com.github.liao47.leetcode.P0779KthSymbolInGrammar;
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

    @Test
    public void test0779() {
        P0779KthSymbolInGrammar solver = new P0779KthSymbolInGrammar();
        for (int i = 1; i <= 32; i++) {
            System.out.print(solver.kthGrammar(6, i));
        }
        Assert.assertEquals(0, solver.kthGrammar(1, 1));
        Assert.assertEquals(0, solver.kthGrammar(2, 1));
        Assert.assertEquals(1, solver.kthGrammar(2, 2));
    }
}
