import com.github.liao47.leetcode.P1838FrequencyOfTheMostFrequentElement;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2021/7/20 14:21
 */
public class LeetCode1830To1839Test {
    @Test
    public void test1838() {
        P1838FrequencyOfTheMostFrequentElement solver = new P1838FrequencyOfTheMostFrequentElement();
        Assert.assertEquals(3, solver.maxFrequency(new int[]{1, 2, 4}, 5));
        Assert.assertEquals(4, solver.maxFrequency(new int[]{1, 2, 4, 4}, 5));
        Assert.assertEquals(2, solver.maxFrequency(new int[]{1, 4, 8, 13}, 5));
        Assert.assertEquals(4, solver.maxFrequency(new int[]{1, 2, 2, 5, 21, 21, 28}, 10));
        Assert.assertEquals(3, solver.maxFrequency(new int[]{1, 8, 8, 9}, 2));
        Assert.assertEquals(73, solver.maxFrequency(new int[]{9930, 9923, 9983, 9997, 9934, 9952, 9945, 9914, 9985,
                9982, 9970, 9932, 9985, 9902, 9975, 9990, 9922, 9990, 9994, 9937, 9996, 9964, 9943, 9963, 9911, 9925,
                9935, 9945, 9933, 9916, 9930, 9938, 10000, 9916, 9911, 9959, 9957, 9907, 9913, 9916, 9993, 9930, 9975
                , 9924, 9988, 9923, 9910, 9925, 9977, 9981, 9927, 9930, 9927, 9925, 9923, 9904, 9928, 9928, 9986,
                9903, 9985, 9954, 9938, 9911, 9952, 9974, 9926, 9920, 9972, 9983, 9973, 9917, 9995, 9973, 9977, 9947,
                9936, 9975, 9954, 9932, 9964, 9972, 9935, 9946, 9966}, 3056));

        Assert.assertEquals(3, solver.maxFrequency2(new int[]{1, 2, 4}, 5));
        Assert.assertEquals(4, solver.maxFrequency2(new int[]{1, 2, 4, 4}, 5));
        Assert.assertEquals(2, solver.maxFrequency2(new int[]{1, 4, 8, 13}, 5));
        Assert.assertEquals(4, solver.maxFrequency2(new int[]{1, 2, 2, 5, 21, 21, 28}, 10));
        Assert.assertEquals(3, solver.maxFrequency2(new int[]{1, 8, 8, 9}, 2));
        Assert.assertEquals(73, solver.maxFrequency2(new int[]{9930, 9923, 9983, 9997, 9934, 9952, 9945, 9914, 9985,
                9982, 9970, 9932, 9985, 9902, 9975, 9990, 9922, 9990, 9994, 9937, 9996, 9964, 9943, 9963, 9911, 9925,
                9935, 9945, 9933, 9916, 9930, 9938, 10000, 9916, 9911, 9959, 9957, 9907, 9913, 9916, 9993, 9930, 9975
                , 9924, 9988, 9923, 9910, 9925, 9977, 9981, 9927, 9930, 9927, 9925, 9923, 9904, 9928, 9928, 9986,
                9903, 9985, 9954, 9938, 9911, 9952, 9974, 9926, 9920, 9972, 9983, 9973, 9917, 9995, 9973, 9977, 9947,
                9936, 9975, 9954, 9932, 9964, 9972, 9935, 9946, 9966}, 3056));
        Assert.assertEquals(3, solver.maxFrequency2(new int[]{1, 2, 4, 5, 8}, 5));
    }
}
