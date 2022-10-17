import com.github.liao47.leetcode.P1694ReformatPhoneNumber;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/10/13 10:15
 */
public class LeetCode1690To1699Test {
    @Test
    public void test1694() {
        P1694ReformatPhoneNumber solver = new P1694ReformatPhoneNumber();
        Assert.assertEquals("123-456", solver.reformatNumber("1-23-45 6"));
        Assert.assertEquals("123-45-67", solver.reformatNumber("123 4-567"));
        Assert.assertEquals("123-456-78", solver.reformatNumber("123 4-5678"));
        Assert.assertEquals("12", solver.reformatNumber("12"));
        Assert.assertEquals("175-229-353-94-75", solver.reformatNumber("--17-5 229 35-39475 "));
    }
}
