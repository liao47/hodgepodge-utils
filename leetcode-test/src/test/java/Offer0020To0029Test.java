import com.github.liao47.leetcode.O0022LianBiaoZhongDaoShuDiKgeJieDianLcof;
import org.junit.Assert;
import org.junit.Test;

import static com.github.liao47.leetcode.O0022LianBiaoZhongDaoShuDiKgeJieDianLcof.ListNode.parse;

/**
 * @author liaoshiqing
 * @date 2021/9/2 9:18
 */
public class Offer0020To0029Test {
    @Test
    public void test0022() {
        O0022LianBiaoZhongDaoShuDiKgeJieDianLcof solver = new O0022LianBiaoZhongDaoShuDiKgeJieDianLcof();
        Assert.assertEquals("4->5", solver.getKthFromEnd(parse("1->2->3->4->5"), 2).toString());
    }
}
