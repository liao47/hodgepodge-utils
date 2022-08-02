import com.github.liao47.leetcode.P0622DesignCircularQueue;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/8/2 14:21
 */
public class LeetCode0620To0629Test {
    @Test
    public void test0622() {
        P0622DesignCircularQueue.MyCircularQueue queue = new P0622DesignCircularQueue.MyCircularQueue(3);
        Assert.assertTrue(queue.enQueue(1));
        Assert.assertTrue(queue.enQueue(2));
        Assert.assertTrue(queue.enQueue(3));
        Assert.assertFalse(queue.enQueue(4));
        Assert.assertEquals(3, queue.Rear());
        Assert.assertTrue(queue.isFull());
        Assert.assertTrue(queue.deQueue());
        Assert.assertTrue(queue.enQueue(4));
        Assert.assertEquals(4, queue.Rear());
        Assert.assertEquals(2, queue.Front());
    }
}
