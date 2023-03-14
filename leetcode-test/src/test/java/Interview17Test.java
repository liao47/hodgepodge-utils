import com.github.liao47.leetcode.I1705;
import com.github.liao47.leetcode.I1714SmallestKLcci;
import com.github.liao47.leetcode.I1719MissingTwoLcci;
import org.junit.Assert;
import org.junit.Test;
import util.AssertUtils;

import java.util.Arrays;

/**
 * @author liaoshiqing
 * @date 2021/9/3 9:20
 */
public class Interview17Test {
    @Test
    public void test1705() {
        I1705 solver = new I1705();
        String[] array = new String[]{"A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7", "H", "I", "J", "K", "L", "M"};
        Assert.assertArrayEquals(new String[]{"A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7"},
                solver.findLongestSubarray(array));
        array = new String[]{"A", "A"};
        Assert.assertArrayEquals(new String[0], solver.findLongestSubarray(array));

        array = new String[]{"42", "10", "O", "t", "y", "p", "g", "B", "96", "H", "5", "v", "P", "52", "25", "96", "b"
                , "L", "Y", "z", "d", "52", "3", "v", "71", "J", "A", "0", "v", "51", "E", "k", "H", "96", "21", "W",
                "59", "I", "V", "s", "59", "w", "X", "33", "29", "H", "32", "51", "f", "i", "58", "56", "66", "90",
                "F", "10", "93", "53", "85", "28", "78", "d", "67", "81", "T", "K", "S", "l", "L", "Z", "j", "5", "R"
                , "b", "44", "R", "h", "B", "30", "63", "z", "75", "60", "m", "61", "a", "5", "S", "Z", "D", "2", "A", "W", "k", "84", "44", "96", "96", "y", "M"};
        Assert.assertArrayEquals(new String[]{"52", "3", "v", "71", "J", "A", "0", "v", "51", "E", "k", "H", "96",
                "21", "W", "59", "I", "V", "s", "59", "w", "X", "33", "29", "H", "32", "51", "f", "i", "58", "56",
                "66", "90", "F", "10", "93", "53", "85", "28", "78", "d", "67", "81", "T", "K", "S", "l", "L", "Z",
                "j", "5", "R", "b", "44", "R", "h", "B", "30", "63", "z", "75", "60", "m", "61", "a", "5"},
                solver.findLongestSubarray(array));
    }

    @Test
    public void test1714() {
        I1714SmallestKLcci solver = new I1714SmallestKLcci();
        int[] result = solver.smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4);
        Arrays.sort(result);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4}, result);
    }

    @Test
    public void test1719() {
        I1719MissingTwoLcci solver = new I1719MissingTwoLcci();
        AssertUtils.assertArray(new int[] {2, 3}, solver.missingTwo(new int[]{1}));
        AssertUtils.assertArray(new int[] {1, 4}, solver.missingTwo(new int[]{2, 3}));
        AssertUtils.assertArray(new int[] {2, 7}, solver.missingTwo(new int[]{1, 3, 8, 5, 4, 6}));
    }
}
