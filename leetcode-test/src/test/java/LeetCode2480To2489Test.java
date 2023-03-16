import com.github.liao47.leetcode.P2488;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2023/3/16 10:07
 */
public class LeetCode2480To2489Test {
    @Test
    public void test2488() {
        P2488 solver = new P2488();
        Assert.assertEquals(3, solver.countSubarrays(new int[]{3, 2, 1, 4, 5}, 4));
        Assert.assertEquals(1, solver.countSubarrays(new int[]{2, 3, 1}, 3));
        Assert.assertEquals(4, solver.countSubarrays(new int[]{5, 4, 3, 2, 1}, 2));
        Assert.assertEquals(3, solver.countSubarrays(new int[]{4, 1, 3, 2}, 1));
    }
}
