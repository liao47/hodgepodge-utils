import com.github.liao47.leetcode.P0643MaximumAverageSubarrayI;
import com.github.liao47.leetcode.P0648ReplaceWords;
import com.github.liao47.leetcode.P0649Dota2Senate;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author liaoshiqing
 * @date 2020/12/11 9:56
 */
public class LeetCode0640To0649Test {

    @Test
    public void test0643() {
        P0643MaximumAverageSubarrayI solver = new P0643MaximumAverageSubarrayI();
        assertEquals(12.75, solver.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4), 0.00);
    }

    @Test
    public void test0648() {
        P0648ReplaceWords solver = new P0648ReplaceWords();
        List<String> dict = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        Assert.assertEquals("the cat was rat by the bat", solver.replaceWords(dict, sentence));

        dict = Arrays.asList("a", "b", "c");
        sentence = "aadsfasf absbs bbab cadsfafs";
        Assert.assertEquals("a a b c", solver.replaceWords(dict, sentence));

        dict = Arrays.asList("catt", "cat", "bat", "rat");
        sentence = "the cattle was rattled by the battery";
        Assert.assertEquals("the cat was rat by the bat", solver.replaceWords(dict, sentence));
    }

    @Test
    public void test0649() {
        P0649Dota2Senate solver = new P0649Dota2Senate();

        assertEquals("Radiant", solver.predictPartyVictory("RD"));
        assertEquals("Dire", solver.predictPartyVictory("RDD"));
        assertEquals("Dire", solver.predictPartyVictory("DDRRR"));
        assertEquals("Dire", solver.predictPartyVictory("RDDRDDR"));

        assertEquals("Radiant", solver.predictPartyVictory2("RD"));
        assertEquals("Dire", solver.predictPartyVictory2("RDD"));
        assertEquals("Dire", solver.predictPartyVictory2("DDRRR"));
        assertEquals("Dire", solver.predictPartyVictory2("RDDRDDR"));

        assertEquals("Radiant", solver.predictPartyVictory3("RD"));
        assertEquals("Dire", solver.predictPartyVictory3("RDD"));
        assertEquals("Dire", solver.predictPartyVictory3("DDRRR"));
        assertEquals("Dire", solver.predictPartyVictory3("RDDRDDR"));
    }
}
