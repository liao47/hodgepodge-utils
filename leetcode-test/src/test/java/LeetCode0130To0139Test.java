import com.github.liao47.leetcode.P0135Candy;
import com.github.liao47.leetcode.P0138CopyListWithRandomPointer;
import com.github.liao47.leetcode.P0138CopyListWithRandomPointer.Node;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author liaoshiqing
 * @date 2020/12/24 10:19
 */
public class LeetCode0130To0139Test {
    @Test
    public void test0135() {
        P0135Candy solver = new P0135Candy();
        assertEquals(5, solver.candy(new int[]{1, 0, 2}));
        assertEquals(4, solver.candy(new int[]{1, 2, 2}));
        assertEquals(16, solver.candy(new int[]{1, 2, 4, 3, 5, 6, 7}));
        assertEquals(14, solver.candy(new int[]{1, 7, 6, 3, 3, 4, 2, 1}));
        assertEquals(16, solver.candy(new int[]{1, 7, 6, 3, 3, 4, 4, 2, 1}));
        assertEquals(9, solver.candy(new int[]{1, 2, 3, 1, 0}));
    }

    @Test
    public void test0138() {
        P0138CopyListWithRandomPointer solver = new P0138CopyListWithRandomPointer();
        String str = "[[7,null],[13,0],[11,4],[10,2],[1,0]]";
        Assert.assertEquals(str, Node.toString(solver.copyRandomList(Node.parse(str))));
        Assert.assertEquals(str, Node.toString(solver.copyRandomList2(Node.parse(str))));
        str = "[[1,1],[2,1]]";
        Assert.assertEquals(str, Node.toString(solver.copyRandomList(Node.parse(str))));
        Assert.assertEquals(str, Node.toString(solver.copyRandomList2(Node.parse(str))));
        str = "[[3,null],[3,0],[3,null]]";
        Assert.assertEquals(str, Node.toString(solver.copyRandomList(Node.parse(str))));
        Assert.assertEquals(str, Node.toString(solver.copyRandomList2(Node.parse(str))));
        str = "[]";
        Assert.assertEquals(str, Node.toString(solver.copyRandomList(Node.parse(str))));
        Assert.assertEquals(str, Node.toString(solver.copyRandomList2(Node.parse(str))));
    }
}
