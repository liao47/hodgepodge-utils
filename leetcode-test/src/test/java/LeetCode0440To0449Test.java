import com.github.liao47.leetcode.P0447NumberOfBoomerangs;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2021/9/13 9:35
 */
public class LeetCode0440To0449Test {
    @Test
    public void test0447() {
        P0447NumberOfBoomerangs solver = new P0447NumberOfBoomerangs();
        Assert.assertEquals(2, solver.numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}}));
        Assert.assertEquals(2, solver.numberOfBoomerangs(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
        Assert.assertEquals(0, solver.numberOfBoomerangs(new int[][]{{1, 1}}));
        Assert.assertEquals(2, solver.numberOfBoomerangs(new int[][]{{0, 0}, {5, 5}, {7, -1}}));
        Assert.assertEquals(4, solver.numberOfBoomerangs(new int[][]{{0, 0}, {5, 5}, {7, -1}, {2, 3}}));
    }
}
