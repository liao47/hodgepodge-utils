import com.github.liao47.leetcode.P0950RevealCardsInIncreasingOrder;
import com.github.liao47.leetcode.P0952LargestComponentSizeByCommonFactor;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2020/12/18 10:30
 */
public class LeetCode0950To0959Test {
    @Test
    public void test0950() {
        P0950RevealCardsInIncreasingOrder solver = new P0950RevealCardsInIncreasingOrder();

        int[] arr = {17, 13, 11, 2, 3, 5, 7};
        assertEquals("[2, 13, 3, 11, 5, 17, 7]", Arrays.toString(solver.deckRevealedIncreasing(arr)));
        assertEquals("[2, 13, 3, 11, 5, 17, 7]", Arrays.toString(solver.deckRevealedIncreasing2(arr)));

        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        assertEquals("[1, 12, 2, 8, 3, 11, 4, 9, 5, 13, 6, 10, 7]",
                Arrays.toString(solver.deckRevealedIncreasing(arr)));
    }

    @Test
    public void test0952() {
        P0952LargestComponentSizeByCommonFactor solver = new P0952LargestComponentSizeByCommonFactor();
        Assert.assertEquals(4, solver.largestComponentSize(new int[]{4, 6, 15, 35}));
        Assert.assertEquals(2, solver.largestComponentSize(new int[]{20, 50, 9, 63}));
        Assert.assertEquals(8, solver.largestComponentSize(new int[]{2, 3, 6, 7, 4, 12, 21, 39}));
        Assert.assertEquals(1, solver.largestComponentSize(new int[]{2}));
    }
}
