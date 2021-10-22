import com.github.liao47.leetcode.P0229MajorityElementII;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author liaoshiqing
 * @date 2021/10/22 9:51
 */
public class LeetCode0220To0229Test {
    @Test
    public void test0229() {
        P0229MajorityElementII solver = new P0229MajorityElementII();
        Assert.assertEquals(solver.majorityElement(new int[]{3, 2, 3}), Collections.singletonList(3));
        Assert.assertEquals(solver.majorityElement(new int[]{1}), Collections.singletonList(1));
        Assert.assertEquals(solver.majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2}), Arrays.asList(1, 2));
        Assert.assertEquals(solver.majorityElement(new int[]{2, 1, 1, 3, 1, 4, 5, 6}), Collections.singletonList(1));
        Assert.assertEquals(solver.majorityElement(new int[]{0, 0, 0, 3, 0, 4, 5, 6}), Collections.singletonList(0));
        Assert.assertEquals(solver.majorityElement(new int[]{0, 0, 0, 0}), Collections.singletonList(0));
    }
}
