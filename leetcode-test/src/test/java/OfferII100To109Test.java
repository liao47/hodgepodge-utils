import com.github.liao47.leetcode.OII1072bCMpM;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author liaoshiqing
 * @date 2021/9/18 17:06
 */
public class OfferII100To109Test {
    @Test
    public void test107() {
        OII1072bCMpM solver = new OII1072bCMpM();
    /*    Assert.assertArrayEquals(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}},
                solver.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        Assert.assertArrayEquals(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 2, 1}},
                solver.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}));
        Assert.assertArrayEquals(new int[][]{{0, 0, 1}, {0, 1, 2}, {1, 2, 3}},
                solver.updateMatrix(new int[][]{{0, 0, 1}, {0, 1, 1}, {1, 1, 1}}));*/
        Assert.assertArrayEquals(new int[][]{{0, 0, 1, 2}, {0, 1, 2, 2}, {1, 2, 2, 1}, {2, 2, 1, 0}},
                solver.updateMatrix(new int[][]{{0, 0, 1, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 0}}));
        Assert.assertArrayEquals(new int[][]{
                        {0, 0, 1, 0, 1, 2, 1, 0, 1, 2},
                        {1, 1, 2, 1, 0, 1, 1, 1, 2, 3},
                        {2, 1, 2, 1, 1, 0, 0, 0, 1, 2},
                        {1, 0, 1, 0, 1, 1, 1, 0, 1, 2},
                        {0, 0, 1, 1, 1, 0, 1, 1, 2, 3},
                        {1, 0, 1, 2, 1, 1, 1, 2, 1, 2},
                        {1, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                        {0, 1, 0, 0, 0, 1, 0, 0, 1, 2},
                        {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1, 0, 1, 2, 1, 0}},
                solver.updateMatrix(new int[][]{
                        {0, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                        {1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 0, 0, 0, 1, 1},
                        {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                        {0, 0, 1, 1, 1, 0, 1, 1, 1, 1},
                        {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                        {0, 1, 0, 0, 0, 1, 0, 0, 1, 1},
                        {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1, 0, 1, 1, 1, 0}}));
        Assert.assertArrayEquals(new int[][]{
                        {2, 1, 0, 0, 1, 0, 0, 1, 1, 0},
                        {1, 0, 0, 1, 0, 1, 1, 2, 2, 1},
                        {1, 1, 1, 0, 0, 1, 2, 2, 1, 0},
                        {0, 1, 2, 1, 0, 1, 2, 3, 2, 1},
                        {0, 0, 1, 2, 1, 2, 1, 2, 1, 0},
                        {1, 1, 2, 3, 2, 1, 0, 1, 1, 1},
                        {0, 1, 2, 3, 2, 1, 1, 0, 0, 1},
                        {1, 2, 1, 2, 1, 0, 0, 1, 1, 2},
                        {0, 1, 0, 1, 1, 0, 1, 2, 2, 3},
                        {1, 2, 1, 0, 1, 0, 1, 2, 3, 4}},
                solver.updateMatrix(new int[][]{
                        {1, 1, 0, 0, 1, 0, 0, 1, 1, 0},
                        {1, 0, 0, 1, 0, 1, 1, 1, 1, 1},
                        {1, 1, 1, 0, 0, 1, 1, 1, 1, 0},
                        {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                        {0, 0, 1, 1, 1, 1, 1, 1, 1, 0},
                        {1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                        {0, 1, 1, 1, 1, 1, 1, 0, 0, 1},
                        {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
                        {0, 1, 0, 1, 1, 0, 1, 1, 1, 1},
                        {1, 1, 1, 0, 1, 0, 1, 1, 1, 1}}));
    }
}
