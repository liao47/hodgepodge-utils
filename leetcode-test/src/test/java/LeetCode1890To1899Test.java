import com.github.liao47.leetcode.P1893CheckIfAllTheIntegersInARangeAreCovered;
import com.github.liao47.leetcode.P1894FindTheStudentThatWillReplaceTheChalk;
import com.github.liao47.leetcode.utils.ReadFileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author liaoshiqing
 * @date 2021/7/23 9:58
 */
public class LeetCode1890To1899Test {
    @Test
    public void test1893() {
        P1893CheckIfAllTheIntegersInARangeAreCovered solver = new P1893CheckIfAllTheIntegersInARangeAreCovered();
        Assert.assertTrue(solver.isCovered(new int[][]{{1, 2}, {3, 4}, {5, 6}}, 2, 5));
        Assert.assertFalse(solver.isCovered(new int[][]{{1, 10}, {10, 20}}, 21, 21));
        Assert.assertTrue(solver.isCovered(new int[][]{{2, 2}, {3, 3}, {1, 1}}, 1, 3));
    }

    @Test
    public void test1894() {
        P1894FindTheStudentThatWillReplaceTheChalk solver = new P1894FindTheStudentThatWillReplaceTheChalk();
        Assert.assertEquals(0, solver.chalkReplacer(new int[]{5, 1, 5}, 22));
        Assert.assertEquals(1, solver.chalkReplacer(new int[]{3, 4, 1, 2}, 25));

        List<String> list = ReadFileUtils.read("P1894.txt");
        int[] chalk = Arrays.stream(list.get(0).split(",")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(list.get(1));
        Assert.assertEquals(10737, solver.chalkReplacer(chalk, k));
    }
}
