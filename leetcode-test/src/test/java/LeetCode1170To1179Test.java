import com.github.liao47.leetcode.P1172DinnerPlates;
import com.github.liao47.leetcode.P1175PrimeArrangements;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/6/30 9:25
 */
public class LeetCode1170To1179Test {
    @Test
    public void test1172() {
        P1172DinnerPlates solver = new P1172DinnerPlates(2);
        solver.push(1);
        solver.push(2);
        solver.push(3);
        solver.push(4);
        solver.push(5);
        Assert.assertEquals(2, solver.popAtStack(0));
        solver.push(20);
        solver.push(21);
        Assert.assertEquals(20, solver.popAtStack(0));
        Assert.assertEquals(21, solver.popAtStack(2));
        Assert.assertEquals(5, solver.pop());
        Assert.assertEquals(4, solver.pop());
        Assert.assertEquals(3, solver.pop());
        Assert.assertEquals(1, solver.pop());
        Assert.assertEquals(-1, solver.pop());

        solver = new P1172DinnerPlates(2);
        solver.push(1);
        solver.push(2);
        solver.push(3);
        solver.push(4);
        solver.push(5);
        Assert.assertEquals(2, solver.popAtStack(0));
        solver.push(20);
        solver.push(21);
        Assert.assertEquals(4, solver.popAtStack(1));
        Assert.assertEquals(3, solver.popAtStack(1));
        Assert.assertEquals(21, solver.pop());
        Assert.assertEquals(5, solver.pop());
        Assert.assertEquals(20, solver.pop());
        Assert.assertEquals(1, solver.pop());
        Assert.assertEquals(-1, solver.pop());
    }

    @Test
    public void test1175() {
        P1175PrimeArrangements solver = new P1175PrimeArrangements();
        Assert.assertEquals(12, solver.numPrimeArrangements(5));
        Assert.assertEquals(682289015, solver.numPrimeArrangements(100));
    }
}
