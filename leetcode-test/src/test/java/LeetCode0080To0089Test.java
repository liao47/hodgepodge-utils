import com.github.liao47.leetcode.P0086PartitionList;
import com.github.liao47.leetcode.P0086PartitionList.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2021/1/4 11:37
 */
public class LeetCode0080To0089Test {
    @Test
    public void test0086() {
        P0086PartitionList solver = new P0086PartitionList();
        ListNode node = ListNode.of(1, 4, 3, 2, 5, 2);
        assertEquals("1 → 2 → 2 → 4 → 3 → 5", solver.partition(node, 3).toString());
    }
}
