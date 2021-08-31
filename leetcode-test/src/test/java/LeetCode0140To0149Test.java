import com.github.liao47.leetcode.P0146LruCache;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2021/8/30 16:43
 */
public class LeetCode0140To0149Test {
    @Test
    public void test0146() {
        P0146LruCache.LruCacheAble cache = this.getLruCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        Assert.assertEquals(1, cache.get(1));
        cache.put(3, 3);
        Assert.assertEquals(-1, cache.get(2));
        cache.put(4, 4);
        Assert.assertEquals(-1, cache.get(1));
        Assert.assertEquals(3, cache.get(3));
        Assert.assertEquals(4, cache.get(4));

        cache = this.getLruCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        Assert.assertEquals(-1, cache.get(1));
        Assert.assertEquals(3, cache.get(2));

        cache = this.getLruCache(1);
        cache.put(2, 1);
        Assert.assertEquals(1, cache.get(2));

        cache = new P0146LruCache.LRUCache(1);
        cache.put(2, 1);
        Assert.assertEquals(1, cache.get(2));
        cache.put(3, 2);
        Assert.assertEquals(-1, cache.get(2));
        Assert.assertEquals(2, cache.get(3));

        cache = this.getLruCache(2);
        cache.put(2, 1);
        cache.put(2, 2);
        Assert.assertEquals(2, cache.get(2));
        cache.put(1, 1);
        cache.put(4, 1);
        Assert.assertEquals(-1, cache.get(2));
    }

    private P0146LruCache.LruCacheAble getLruCache(int capacity) {
        return new P0146LruCache.LRUCache2(capacity);
    }
}
