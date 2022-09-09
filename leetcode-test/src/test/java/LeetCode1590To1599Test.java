import com.github.liao47.leetcode.P1592RearrangeSpacesBetweenWords;
import com.github.liao47.leetcode.P1598CrawlerLogFolder;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author liaoshiqing
 * @date 2022/9/7 9:48
 */
public class LeetCode1590To1599Test {
    @Test
    public void test1592() {
        P1592RearrangeSpacesBetweenWords solver = new P1592RearrangeSpacesBetweenWords();
        assertEquals("this   is   a   sentence", solver.reorderSpaces("  this   is  a sentence "));
        assertEquals("practice   makes   perfect ", solver.reorderSpaces(" practice   makes   perfect"));
        assertEquals("hello   world", solver.reorderSpaces("hello   world"));
        assertEquals("walks  udp  package  into  bar  a ", solver.reorderSpaces("  walks  udp package   into  bar a"));
        assertEquals("a", solver.reorderSpaces("a"));
        assertEquals("a  ", solver.reorderSpaces("  a"));
        assertEquals("a  ", solver.reorderSpaces(" a "));
        assertEquals("a b c ", solver.reorderSpaces("a b  c"));
        assertEquals("a b c d  ", solver.reorderSpaces("a b   c d"));
    }

    @Test
    public void test1598() {
        P1598CrawlerLogFolder solver = new P1598CrawlerLogFolder();
        Assert.assertEquals(2, solver.minOperations(new String[]{"d1/", "d2/", "../", "d21/", "./"}));
        Assert.assertEquals(3, solver.minOperations(new String[]{"d1/", "d2/", "./", "d3/", "../", "d31/"}));
        Assert.assertEquals(0, solver.minOperations(new String[]{"d1/", "../", "../", "../"}));
    }
}
