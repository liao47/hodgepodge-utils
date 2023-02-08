import com.github.liao47.leetcode.P1604;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author liaoshiqing
 * @date 2023/2/8 9:28
 */
public class LeetCode1600To1609Test {
    @Test
    public void test1604() {
        P1604 solver = new P1604();
        String[] keyName = new String[]{"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"};
        String[] keyTime = new String[]{"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"};
        Assert.assertEquals(Collections.singletonList("daniel"), solver.alertNames(keyName, keyTime));

        keyName = new String[]{"alice", "alice", "alice", "bob", "bob", "bob", "bob"};
        keyTime = new String[]{"12:01", "12:00", "18:00", "21:00", "21:20", "21:30", "23:00"};
        Assert.assertEquals(Collections.singletonList("bob"), solver.alertNames(keyName, keyTime));

        keyName = new String[]{"john", "john", "john"};
        keyTime = new String[]{"23:58", "23:59", "00:01"};
        Assert.assertEquals(Collections.emptyList(), solver.alertNames(keyName, keyTime));

        keyName = new String[]{"leslie", "leslie", "leslie", "clare", "clare", "clare", "clare"};
        keyTime = new String[]{"13:00", "13:20", "14:00", "18:00", "18:51", "19:30", "19:49"};
        Assert.assertEquals(Arrays.asList("clare", "leslie"), solver.alertNames(keyName, keyTime));
    }
}
