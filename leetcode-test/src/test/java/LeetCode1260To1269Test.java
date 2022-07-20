import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.liao47.leetcode.P1260Shift2dGrid;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

/**
 * @author liaoshiqing
 * @date 2022/7/20 9:26
 */
public class LeetCode1260To1269Test {
    @Test
    public void test1260() {
        P1260Shift2dGrid solver = new P1260Shift2dGrid();
        Class<int[][]> clazz = int[][].class;
        Type type = new TypeReference<List<List<Integer>>>(){}.getType();

        int[][] grid = JSON.parseObject("[[1,2,3],[4,5,6],[7,8,9]]", clazz);
        List<List<Integer>> res = JSON.parseObject("[[9,1,2],[3,4,5],[6,7,8]]", type);
        Assert.assertEquals(res, solver.shiftGrid(grid, 1));

        grid = JSON.parseObject("[[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]]", clazz);
        res = JSON.parseObject("[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]", type);
        Assert.assertEquals(res, solver.shiftGrid(grid, 4));

        grid = JSON.parseObject("[[1,2,3],[4,5,6],[7,8,9]]", clazz);
        res = JSON.parseObject("[[1,2,3],[4,5,6],[7,8,9]]", type);
        Assert.assertEquals(res, solver.shiftGrid(grid, 9));
    }
}
