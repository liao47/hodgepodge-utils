import com.github.liao47.leetcode.P0828CountUniqueCharactersOfAllSubstringsOfAGivenString;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/9/6 13:54
 */
public class LeetCode0820To0829Test {
    @Test
    public void test0828() {
        P0828CountUniqueCharactersOfAllSubstringsOfAGivenString solver =
                new P0828CountUniqueCharactersOfAllSubstringsOfAGivenString();
        Assert.assertEquals(10, solver.uniqueLetterString("ABC"));
        Assert.assertEquals(8, solver.uniqueLetterString("ABA"));
        Assert.assertEquals(92, solver.uniqueLetterString("LEETCODE"));
    }
}
