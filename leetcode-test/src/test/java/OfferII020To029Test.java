import com.github.liao47.leetcode.OII029;
import com.github.liao47.leetcode.bo.Node;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author liaoshiqing
 * @date 2022/6/30 10:52
 */
public class OfferII020To029Test {
    @Test
    public void test029() {
        OII029 solver = new OII029();
        Node head = Node.of(new int[]{3, 4, 1});
        head = solver.insert(head, 2);
        Assert.assertEquals(Arrays.asList(3, 4, 1, 2), Node.toList(head));

        head = Node.of(new int[0]);
        head = solver.insert(head, 1);
        Assert.assertEquals(Collections.singletonList(1), Node.toList(head));

        head = Node.of(new int[]{1});
        head = solver.insert(head, 0);
        Assert.assertEquals(Arrays.asList(1, 0), Node.toList(head));

        head = Node.of(new int[]{2, 2});
        head = solver.insert(head, 1);
        Assert.assertEquals(Arrays.asList(2, 2, 1), Node.toList(head));

        head = Node.of(new int[]{2, 2});
        head = solver.insert(head, 3);
        Assert.assertEquals(Arrays.asList(2, 2, 3), Node.toList(head));

        head = Node.of(new int[]{3, 5, 1});
        head = solver.insert(head, 6);
        Assert.assertEquals(Arrays.asList(3, 5, 6, 1), Node.toList(head));

        head = Node.of(new int[]{2, 2, 3});
        head = solver.insert(head, 4);
        Assert.assertEquals(Arrays.asList(2, 2, 3, 4), Node.toList(head));
    }
}
