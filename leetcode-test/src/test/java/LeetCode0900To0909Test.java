import com.github.liao47.leetcode.P0904FruitIntoBaskets;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/10/17 10:01
 */
public class LeetCode0900To0909Test {
    @Test
    public void test0904() {
        P0904FruitIntoBaskets solver = new P0904FruitIntoBaskets();
        Assert.assertEquals(3, solver.totalFruit(new int[]{1, 2, 1}));
        Assert.assertEquals(3, solver.totalFruit(new int[]{0, 1, 2, 2}));
        Assert.assertEquals(4, solver.totalFruit(new int[]{1, 2, 3, 2, 2}));
        Assert.assertEquals(5, solver.totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
        Assert.assertEquals(5, solver.totalFruit(new int[]{1, 0, 1, 4, 1, 4, 1, 2, 3}));
        Assert.assertEquals(3, solver.totalFruit(new int[]{1, 0, 3, 4, 3}));
        Assert.assertEquals(5, solver.totalFruit(new int[]{1, 0, 0, 3, 3, 4, 4, 3}));
    }
}
