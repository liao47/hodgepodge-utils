import com.alibaba.fastjson.JSON;
import com.github.liao47.leetcode.P0757SetIntersectionSizeAtLeastTwo;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/7/22 13:47
 */
public class LeetCode0750To0759Test {
    @Test
    public void test0757() {
        P0757SetIntersectionSizeAtLeastTwo solver = new P0757SetIntersectionSizeAtLeastTwo();
        Class<int[][]> clazz = int[][].class;
        int[][] intervals = JSON.parseObject("[[1, 3], [1, 4], [2, 5], [3, 5]]", clazz);
        Assert.assertEquals(3, solver.intersectionSizeTwo(intervals));
        intervals = JSON.parseObject("[[1, 2], [2, 3], [2, 4], [4, 5]]", clazz);
        Assert.assertEquals(5, solver.intersectionSizeTwo(intervals));
        intervals = JSON.parseObject("[[2,10],[3,7],[3,15],[4,11],[6,12],[6,16],[7,8],[7,11],[7,15],[11,12]]", clazz);
        Assert.assertEquals(5, solver.intersectionSizeTwo(intervals));
        intervals = JSON.parseObject("[[1,3],[4,9],[0,10],[6,7],[1,2],[0,6],[7,9],[0,1],[2,5],[6,8]]", clazz);
        Assert.assertEquals(7, solver.intersectionSizeTwo(intervals));
        intervals = JSON.parseObject("[[0, 1], [1, 2], [2, 5], [4, 9], [6, 7], [7, 9]]", clazz);
        Assert.assertEquals(7, solver.intersectionSizeTwo(intervals));
        intervals = JSON.parseObject("[[1, 3],[3, 7],[5, 9]]", clazz);
        Assert.assertEquals(4, solver.intersectionSizeTwo(intervals));
        intervals = JSON.parseObject("[[1,3],[3,7],[5,7],[7,8]]", clazz);
        Assert.assertEquals(5, solver.intersectionSizeTwo(intervals));
    }
}
