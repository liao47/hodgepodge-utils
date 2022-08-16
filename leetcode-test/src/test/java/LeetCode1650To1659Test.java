import com.github.liao47.leetcode.P1656DesignAnOrderedStream;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author liaoshiqing
 * @date 2022/8/16 9:44
 */
public class LeetCode1650To1659Test {
    @Test
    public void test1656() {
        P1656DesignAnOrderedStream.OrderedStream os = new P1656DesignAnOrderedStream.OrderedStream(5);
        Assert.assertEquals(Collections.emptyList(), os.insert(3, "ccccc"));
        Assert.assertEquals(Collections.singletonList("aaaaa"), os.insert(1, "aaaaa"));
        Assert.assertEquals(Arrays.asList("bbbbb", "ccccc"), os.insert(2, "bbbbb"));
        Assert.assertEquals(Collections.emptyList(), os.insert(5, "eeeee"));
        Assert.assertEquals(Arrays.asList("ddddd", "eeeee"), os.insert(4, "ddddd"));
    }
}
