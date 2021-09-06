import com.github.liao47.leetcode.I1714SmallestKLcci;
import org.junit.Assert;
import org.junit.Test;

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
}
