import com.github.liao47.leetcode.P1175PrimeArrangements;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/6/30 9:25
 */
public class LeetCode1170To1179Test {
    @Test
    public void test1175() {
        P1175PrimeArrangements solver = new P1175PrimeArrangements();
        Assert.assertEquals(12, solver.numPrimeArrangements(5));
        Assert.assertEquals(682289015, solver.numPrimeArrangements(100));
    }
}
