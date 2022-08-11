import com.github.liao47.leetcode.P1417ReformatTheString;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/8/11 9:27
 */
public class LeetCode1410To1419Test {
    @Test
    public void test1417() {
        P1417ReformatTheString solver = new P1417ReformatTheString();
        assert1417(solver.reformat("a0b1c2"), "a0b1c2");
        assert1417(solver.reformat("leetcode"), "leetcode");
        assert1417(solver.reformat("1229857369"), "1229857369");
        assert1417(solver.reformat("covid2019"), "covid2019");
        assert1417(solver.reformat("ab123"), "ab123");
    }

    private void assert1417(String result, String param) {
        int[] arr = new int[75];
        int count = 0;
        for (char c : param.toCharArray()) {
            arr[c - '0']++;
            if (c <= '9') {
                count++;
            } else {
                count--;
            }
        }
        if (Math.abs(count) > 1) {
            Assert.assertEquals("", result);
            return;
        }

        int prev = -1;
        for (char c : result.toCharArray()) {
            Assert.assertTrue(arr[c - '0']-- > 0);
            int curr = c <= '9' ? 0 : 1;
            if (prev != -1) {
                Assert.assertEquals(1, curr ^ prev);
            }
            prev = curr;
        }
    }
}
