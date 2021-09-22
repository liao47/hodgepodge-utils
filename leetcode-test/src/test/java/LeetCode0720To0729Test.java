import com.github.liao47.leetcode.P0725SplitLinkedListInParts;
import com.github.liao47.leetcode.P0725SplitLinkedListInParts.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author liaoshiqing
 * @date 2021/9/22 14:00
 */
public class LeetCode0720To0729Test {
    @Test
    public void test0725() {
        P0725SplitLinkedListInParts solver = new P0725SplitLinkedListInParts();

        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3)));
    //    Assert.assertEquals("[[1], [2], [3], null, null]", Arrays.toString(solver.splitListToParts(node, 5)));

        node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,
                new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(9, new ListNode(10))))))))));
        Assert.assertEquals("[[1,2,3,4], [5,6,7], [8,9,10]]", Arrays.toString(solver.splitListToParts(node, 3)));
    }
}
