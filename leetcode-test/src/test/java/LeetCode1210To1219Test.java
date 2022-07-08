import com.github.liao47.leetcode.P1217MinimumCostToMoveChipsToTheSamePosition;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/7/8 13:56
 */
public class LeetCode1210To1219Test {
    @Test
    public void test1217() {
        P1217MinimumCostToMoveChipsToTheSamePosition sovler = new P1217MinimumCostToMoveChipsToTheSamePosition();
        Assert.assertEquals(1, sovler.minCostToMoveChips(new int[]{1, 2, 3}));
        Assert.assertEquals(2, sovler.minCostToMoveChips(new int[]{2, 2, 2, 3, 3}));
        Assert.assertEquals(1, sovler.minCostToMoveChips(new int[]{1, 1000000000}));
    }
}
