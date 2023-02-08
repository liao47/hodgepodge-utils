import com.github.liao47.leetcode.P1233;
import org.junit.Assert;
import org.junit.Test;
import util.AssertUtils;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author liaoshiqing
 * @date 2023/2/8 10:51
 */
public class LeetCode1230To1239Test {
    @Test
    public void test1233() {
        P1233 solver = new P1233();
        AssertUtils.assertList(Arrays.asList("/a", "/c/d", "/c/f"), solver.removeSubfolders(new String[]{"/a", "/a/b"
                , "/c/d", "/c/d/e", "/c/f"}));
        AssertUtils.assertList(Collections.singletonList("/a"), solver.removeSubfolders(new String[]{"/a", "/a/b/c",
                "/a/b/d"}));
        AssertUtils.assertList(Arrays.asList("/a/b/c", "/a/b/ca", "/a/b/d"), solver.removeSubfolders(new String[]{
                "/a/b/c", "/a/b/ca", "/a/b/d"}));
        AssertUtils.assertList(Arrays.asList("/aa/ab/ac/ae", "/aa/ab/af/ag", "/aa/ab/af/ah", "/aa/ai/aj/ak",
                "/aa/ai/am/ao", "/ap"), solver.removeSubfolders(new String[]{"/aa/ab/ac/ae", "/aa/ab/af/ag",
                "/ap/aq/ar/as", "/ap/aq/ar", "/ap/ax/ay/az", "/ap", "/ap/aq/ar/at", "/aa/ab/af/ah", "/aa/ai/aj/ak",
                "/aa/ai/am/ao"}));
    }
}
