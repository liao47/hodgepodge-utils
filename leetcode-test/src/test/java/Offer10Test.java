import com.github.liao47.leetcode.O1001FeiBoNaQiShuLieLcof;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2021/9/18 11:20
 */
public class Offer10Test {
    @Test
    public void test01() {
        O1001FeiBoNaQiShuLieLcof solver = new O1001FeiBoNaQiShuLieLcof();
        Assert.assertEquals(0, solver.fib(0));
        Assert.assertEquals(1, solver.fib(2));
        Assert.assertEquals(5, solver.fib(5));
        Assert.assertEquals(134903163, solver.fib(45));
        Assert.assertEquals(807526948, solver.fib(48));
    }
}
