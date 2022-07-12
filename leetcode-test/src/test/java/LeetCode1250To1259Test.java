import com.github.liao47.leetcode.P1252CellsWithOddValuesInAMatrix;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/7/12 13:56
 */
public class LeetCode1250To1259Test {
    @Test
    public void test1252() {
        P1252CellsWithOddValuesInAMatrix solver = new P1252CellsWithOddValuesInAMatrix();
        Assert.assertEquals(6, solver.oddCells(2, 3,new int[][]{{0, 1}, {1, 1}}));
        Assert.assertEquals(0, solver.oddCells(2, 2,new int[][]{{1, 1}, {0, 0}}));
        Assert.assertEquals(10, solver.oddCells(4, 4, new int[][]{{0, 1}, {0, 1}, {0, 2}, {1, 1},
                {2, 1}, {2, 3}, {3, 2}}));
    }
}
