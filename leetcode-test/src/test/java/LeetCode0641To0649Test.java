import com.github.liao47.leetcode.LeetCode0649;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author liaoshiqing
 * @date 2020/12/11 9:56
 */
public class LeetCode0641To0649Test {

    @Test
    public void test0649() {
        LeetCode0649 solver = new LeetCode0649();

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
