import com.github.liao47.leetcode.LeetCode0049;
import org.junit.Test;

/**
 * @author liao47
 * @date 2020/12/14 16:07
 */
public class LeetCode0041To0049Test {
    @Test
    public void test0049() {
        LeetCode0049 solver = new LeetCode0049();

        String[] strArr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solver.groupAnagrams(strArr));
        System.out.println(solver.groupAnagrams2(strArr));

        strArr = new String[]{"ddddddddddg", "dgggggggggg"};
        System.out.println(solver.groupAnagrams(strArr));
        System.out.println(solver.groupAnagrams2(strArr));

        strArr = new String[]{"aaabb", "aabbb"};
        System.out.println(solver.groupAnagrams(strArr));
        System.out.println(solver.groupAnagrams2(strArr));
    }
}
