import com.github.liao47.leetcode.P0399EvaluateDivision;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author liao47
 * @date 2021/1/6 10:00
 */
public class LeetCode0390To0399Test {
    @Test
    public void test0399() {
        P0399EvaluateDivision solver = new P0399EvaluateDivision();
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        double[] values = new double[]{2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));
        assertArrayEquals(new double[]{6.0, 0.5, -1.0, 1.0, -1.0}, solver.calcEquation(equations, values, queries),
                0.0);
    }
}
