import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.liao47.leetcode.P1282GroupThePeopleGivenTheGroupSizeTheyBelongTo;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.List;

/**
 * @author liaoshiqing
 * @date 2022/8/12 9:24
 */
public class LeetCode1280To1289Test {
    @Test
    public void test1282() {
        P1282GroupThePeopleGivenTheGroupSizeTheyBelongTo solver =
                new P1282GroupThePeopleGivenTheGroupSizeTheyBelongTo();
        Type type = new TypeReference<List<List<Integer>>>() {}.getType();
        List<List<Integer>> result = solver.groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3});
        assert1282(JSON.parseObject("[[5],[0,1,2],[3,4,6]]", type), result);
        result = solver.groupThePeople(new int[]{2, 1, 3, 3, 3, 2});
        assert1282(JSON.parseObject("[[1],[0,5],[2,3,4]]", type), result);
    }

    private void assert1282(List<List<Integer>> expected, List<List<Integer>> actual) {
        Comparator<List<Integer>> comparator = (a, b) -> a.size() == b.size() ? a.get(0).compareTo(b.get(0)) :
                Integer.compare(a.size(), b.size());
        expected.sort(comparator);
        actual.sort(comparator);
        Assert.assertEquals(expected, actual);
    }
}
