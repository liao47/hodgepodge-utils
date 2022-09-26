import com.github.liao47.leetcode.I1714SmallestKLcci;
import com.github.liao47.leetcode.I1719MissingTwoLcci;
import org.junit.Assert;
import org.junit.Test;
import util.AssertUtils;

import java.util.Arrays;

/**
 * @author liaoshiqing
 * @date 2021/9/3 9:20
 */
public class Interview17Test {
    @Test
    public void test1714() {
        I1714SmallestKLcci solver = new I1714SmallestKLcci();
        int[] result = solver.smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4);
        Arrays.sort(result);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4}, result);
    }

    @Test
    public void test1719() {
        I1719MissingTwoLcci solver = new I1719MissingTwoLcci();
        AssertUtils.assertArray(new int[] {2, 3}, solver.missingTwo(new int[]{1}));
        AssertUtils.assertArray(new int[] {1, 4}, solver.missingTwo(new int[]{2, 3}));
        AssertUtils.assertArray(new int[] {2, 7}, solver.missingTwo(new int[]{1, 3, 8, 5, 4, 6}));
    }
}
