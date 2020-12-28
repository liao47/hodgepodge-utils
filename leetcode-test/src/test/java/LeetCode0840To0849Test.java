import com.github.liao47.leetcode.P0842SplitArrayIntoFibonacciSequence;
import org.junit.Test;

/**
 * @author liao47
 * @date 2020/12/17 15:43
 */
public class LeetCode0840To0849Test {
    @Test
    public void test0842() {
        P0842SplitArrayIntoFibonacciSequence solver = new P0842SplitArrayIntoFibonacciSequence();

        System.out.println(solver.splitIntoFibonacci("123456579"));
        System.out.println(solver.splitIntoFibonacci("11235813"));
        System.out.println(solver.splitIntoFibonacci("112358130"));
        System.out.println(solver.splitIntoFibonacci("0123"));
        System.out.println(solver.splitIntoFibonacci("1101111"));
        System.out.println(solver.splitIntoFibonacci("17522"));
        System.out.println(solver.splitIntoFibonacci("0123"));
        System.out.println(solver.splitIntoFibonacci("214748364721474836422147483641"));
        System.out.println(solver.splitIntoFibonacci("12324"));
    }
}
