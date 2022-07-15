import com.alibaba.fastjson.JSON;
import com.github.liao47.leetcode.P0558LogicalOrOfTwoBinaryGridsRepresentedAsQuadTrees;
import com.github.liao47.leetcode.P0558LogicalOrOfTwoBinaryGridsRepresentedAsQuadTrees.Node;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author liaoshiqing
 * @date 2022/7/15 14:07
 */
public class LeetCode0550To0559Test {
    @Test
    public void test0558() {
        P0558LogicalOrOfTwoBinaryGridsRepresentedAsQuadTrees solver =
                new P0558LogicalOrOfTwoBinaryGridsRepresentedAsQuadTrees();
        Node quadTree1 = Node.of("[[0,1],[1,1],[1,1],[1,0],[1,0]]");
        Node quadTree2 = Node.of("[[0,1],[1,1],[0,1],[1,1],[1,0],null,null,null,null,[1,0],[1,0],[1,1],[1,1]]");
        assertEquals("[[0,0],[1,1],[1,1],[1,1],[1,0]]",
                Node.toString(solver.intersect(quadTree1, quadTree2)));

        quadTree1 = Node.of("[[1,0]]");
        quadTree2 = Node.of("[[1,0]]");
        assertEquals("[[1,0]]", Node.toString(solver.intersect(quadTree1, quadTree2)));

        quadTree1 = Node.of("[[0,0],[1,0],[1,0],[1,1],[1,1]]");
        quadTree2 = Node.of("[[0,0],[1,1],[1,1],[1,0],[1,1]]");
        assertEquals("[[1,1]]", Node.toString(solver.intersect(quadTree1, quadTree2)));

        quadTree1 = Node.of("[[0,0],[1,0],[1,0],[1,1],[1,0]]");
        quadTree2 = Node.of("[[0,0],[1,1],[1,1],[1,0],[1,0]]");
        assertEquals("[[0,0],[1,1],[1,1],[1,1],[1,0]]", Node.toString(solver.intersect(quadTree1, quadTree2)));

        quadTree1 = Node.of("[[0,0],[1,1],[1,0],[1,1],[1,1]]");
        quadTree2 = Node.of("[[0,0],[1,1],[0,1],[1,1],[1,1],null,null,null,null,[1,1],[1,0],[1,0],[1,1]]");
        assertEquals("[[0,0],[1,1],[0,1],[1,1],[1,1],null,null,null,null,[1,1],[1,0],[1,0],[1,1]]",
                Node.toString(solver.intersect(quadTree1, quadTree2)));

        quadTree1 = Node.of("[[0,1],[1,0],[0,1],[1,1],[1,0],null,null,null,null,[1,0],[1,0],[1,1],[1,1]]");
        quadTree2 = Node.of("[[0,1],[0,1],[1,0],[1,1],[1,0],[1,0],[1,0],[1,1],[1,1]]");
        assertEquals("[[0,0],[0,1],[0,1],[1,1],[1,0],[1,0],[1,0],[1,1],[1,1],[1,0],[1,0],[1,1],[1,1]]",
                Node.toString(solver.intersect(quadTree1, quadTree2)));

        quadTree1 = Node.of("[[0,0],[1,1],[0,0],[0,0],[0,0],null,null,null,null,[0,0],[0,0],[0,0],[1,1],[1,0],[0,0]," +
                "[0,0],[0,0],[1,1],[1,0],[0,0],[0,0],[1,1],[1,0],[1,1],[1,0],[1,1],[1,0],[1,0],[1,1],[1,1],[1,0],[1," +
                "0],[1,0],null,null,null,null,null,null,null,null,[1,0],[1,1],[1,1],[1,0],[1,1],[1,0],[1,0],[1,0],[1," +
                "0],[1,0],[1,1],[1,0],null,null,null,null,null,null,null,null,[1,1],[1,0],[1,1],[1,0],[1,0],[1,1],[1," +
                "1],[1,0]]");
        quadTree2 = Node.of("[[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[1,1],[0,0],[0,0],[0,0],[1,1],[0," +
                "0],[0,0],[0,0],[1,1],[0,0],[1,0],[1,0],[1,1],[1,0],[1,1],[1,0],[1,1],[1,0],[1,1],[1,1],[1,0],[1,1]," +
                "[1,1],[1,1],[1,1],[1,0],[1,1],[1,0],[1,0],[1,1],[1,1],[1,0],[1,0],[1,0],null,null,null,null,[1,1]," +
                "[1,1],[1,0],[1,0],[1,0],[1,0],[1,1],[1,1],[1,1],[1,1],[1,0],[1,0],null,null,null,null,[1,0],[1,1]," +
                "[1,0],[1,0],[1,1],[1,0],[1,1],[1,1],[1,0],[1,1],[1,1],[1,0],null,null,null,null,[1,0],[1,1],[1,1]," +
                "[1,1]]");
        assertEquals("[[0,0],[1,1],[0,0],[0,0],[0,0],null,null,null,null,[0,0],[0,0],[1,1],[1,1],[0,0],[0,0],[1,1]," +
                        "[0,0],[1,1],[0,0],[1,1],[0,0],[1,1],[1,0],[1,1],[1,1],[1,1],[1,0],[1,0],[1,1],null,null," +
                        "null,null,null,null,null,null,[1,0],[1,0],[1,1],[1,1],[1,1],[1,1],[1,1],[1,0],null,null," +
                        "null,null,[1,0],[1,1],[1,1],[1,0],null,null,null,null,[1,0],[1,1],[1,1],[1,0],null,null," +
                        "null,null,[1,0],[1,1],[1,1],[1,1]]",
                Node.toString(solver.intersect(quadTree1, quadTree2)));
    }

    public static void main(String[] args) {
        print("[[0,0],[1,1],[0,0],[0,0],[0,0],null,null,null,null,[0,0],[1,1],[1,1],[1,1],[0,0],[0,0],[1,1],[1,0],[1," +
                "1],[0,0],[1,1],[0,0],[1,1],[1,0],[1,1],[1,1],null,null,null,null,null,null,null,null,null,null,null," +
                "null,[1,0],[1,0],[1,1],[1,1],[1,1],[1,1],[1,1],[1,0],null,null,null,null,null,null,null,null,null," +
                "null,null,null,[1,0],[1,1],[1,1],[1,0],null,null,null,null,[1,0],[1,1],[1,1],[1,1]]");
        System.out.println("#######");
        print("[[0,0],[1,1],[0,0],[0,0],[0,0],null,null,null,null,[0,0],[0,0],[1,1],[1,1],[0,0],[0,0],[1,1],[0,0],[1," +
                "1],[0,0],[1,1],[0,0],[1,1],[1,0],[1,1],[1,1],[1,1],[1,0],[1,0],[1,1],null,null,null,null,null,null," +
                "null,null,[1,0],[1,0],[1,1],[1,1],[1,1],[1,1],[1,1],[1,0],null,null,null,null,[1,0],[1,1],[1,1],[1," +
                "0],null,null,null,null,[1,0],[1,1],[1,1],[1,0],null,null,null,null,[1,0],[1,1],[1,1],[1,1]]");
    }

    private static void print(String str) {
        List<int[]> list = JSON.parseArray(str, int[].class);
        System.out.println(Arrays.toString(list.get(0)));
        int index = 1;
        int k = 0;
        while (index < list.size()) {
            System.out.println(JSON.toJSONString(list.subList(index, index += 4)));
            if (k % 4 == 0) {
                System.out.println("");
            }
            if (k % 16 == 0) {
                System.out.println("----------------");
            }
            k++;
        }
    }
}
