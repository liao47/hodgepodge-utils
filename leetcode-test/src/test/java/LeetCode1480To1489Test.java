import com.github.liao47.leetcode.P1487;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2023/3/3 14:32
 */
public class LeetCode1480To1489Test {
    @Test
    public void test1487() {
        P1487 solver = new P1487();
        Assert.assertArrayEquals(new String[]{"pes", "fifa", "gta", "pes(2019)"}, solver.getFolderNames(new String[]{
                "pes", "fifa", "gta", "pes(2019)"}));
        Assert.assertArrayEquals(new String[]{"gta", "gta(1)", "gta(2)", "avalon"},
                solver.getFolderNames(new String[]{"gta", "gta(1)", "gta", "avalon"}));
        Assert.assertArrayEquals(new String[]{"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece(4)"},
                solver.getFolderNames(new String[]{"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece"
                }));
        Assert.assertArrayEquals(new String[]{"wano", "wano(1)", "wano(2)", "wano(3)"},
                solver.getFolderNames(new String[]{"wano", "wano", "wano", "wano"}));
        Assert.assertArrayEquals(new String[]{"kaido","kaido(1)","kaido(2)","kaido(1)(1)"},
                solver.getFolderNames(new String[]{"kaido","kaido(1)","kaido","kaido(1)"}));
        Assert.assertArrayEquals(new String[]{"onepiece", "onepiece(2)", "onepiece(3)", "onepiece(1)"},
                solver.getFolderNames(new String[]{"onepiece", "onepiece(2)", "onepiece(3)", "onepiece"}));
        Assert.assertArrayEquals(new String[]{"kaido", "kaido(1)", "kaido(2)", "kaido(1)(1)", "kaido(2)(1)"},
                solver.getFolderNames(new String[]{"kaido", "kaido(1)", "kaido", "kaido(1)", "kaido(2)"}));
        Assert.assertArrayEquals(new String[]{"kingston(0)", "kingston", "kingston(1)"},
                solver.getFolderNames(new String[]{"kingston(0)", "kingston", "kingston"}));
        Assert.assertArrayEquals(new String[]{"kingston(1)", "kingston", "kingston(2)"},
                solver.getFolderNames(new String[]{"kingston(1)", "kingston", "kingston"}));
    }
}
