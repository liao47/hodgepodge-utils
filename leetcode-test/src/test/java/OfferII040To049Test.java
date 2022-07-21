import com.github.liao47.leetcode.OII041;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/7/21 16:00
 */
public class OfferII040To049Test {
    @Test
    public void test041() {
        double delta = 0.00001;
        OII041.MovingAverage movingAverage = new OII041.MovingAverage(3);
        Assert.assertEquals(1, movingAverage.next(1), delta);
        Assert.assertEquals(5.5, movingAverage.next(10), delta);
        Assert.assertEquals(4.66667, movingAverage.next(3), delta);
        Assert.assertEquals(6, movingAverage.next(5), delta);
    }
}
