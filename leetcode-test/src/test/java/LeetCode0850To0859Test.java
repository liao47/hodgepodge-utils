import com.github.liao47.leetcode.P0855ExamRoom;
import com.github.liao47.leetcode.P0856ScoreOfParentheses;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/10/9 10:41
 */
public class LeetCode0850To0859Test {
    @Test
    public void test0855() {
        P0855ExamRoom.ExamRoom examRoom = new P0855ExamRoom.ExamRoom(10);
        Assert.assertEquals(0, examRoom.seat());
        Assert.assertEquals(9, examRoom.seat());
        Assert.assertEquals(4, examRoom.seat());
        Assert.assertEquals(2, examRoom.seat());
        examRoom.leave(4);
        Assert.assertEquals(5, examRoom.seat());

        examRoom = new P0855ExamRoom.ExamRoom(10);
        Assert.assertEquals(0, examRoom.seat());
        Assert.assertEquals(9, examRoom.seat());
        Assert.assertEquals(4, examRoom.seat());
        examRoom.leave(0);
        Assert.assertEquals(0, examRoom.seat());

        examRoom = new P0855ExamRoom.ExamRoom(10);
        Assert.assertEquals(0, examRoom.seat());
        Assert.assertEquals(9, examRoom.seat());
        Assert.assertEquals(4, examRoom.seat());
        examRoom.leave(0);
        examRoom.leave(4);
        Assert.assertEquals(0, examRoom.seat());
        Assert.assertEquals(4, examRoom.seat());
        Assert.assertEquals(2, examRoom.seat());
        Assert.assertEquals(6, examRoom.seat());
        Assert.assertEquals(1, examRoom.seat());
        Assert.assertEquals(3, examRoom.seat());
        Assert.assertEquals(5, examRoom.seat());
        Assert.assertEquals(7, examRoom.seat());
        Assert.assertEquals(8, examRoom.seat());
        examRoom.leave(0);
        examRoom.leave(4);
        Assert.assertEquals(0, examRoom.seat());
        Assert.assertEquals(4, examRoom.seat());
        examRoom.leave(7);
        Assert.assertEquals(7, examRoom.seat());
        examRoom.leave(3);
        Assert.assertEquals(3, examRoom.seat());
        examRoom.leave(3);
        Assert.assertEquals(3, examRoom.seat());
        examRoom.leave(9);
        Assert.assertEquals(9, examRoom.seat());
        examRoom.leave(0);
        examRoom.leave(8);
        Assert.assertEquals(0, examRoom.seat());
        Assert.assertEquals(8, examRoom.seat());
        examRoom.leave(0);
        examRoom.leave(8);
        Assert.assertEquals(0, examRoom.seat());
        Assert.assertEquals(8, examRoom.seat());
        examRoom.leave(2);

        examRoom = new P0855ExamRoom.ExamRoom(8);
        Assert.assertEquals(0, examRoom.seat());
        Assert.assertEquals(7, examRoom.seat());
        Assert.assertEquals(3, examRoom.seat());
        examRoom.leave(0);
        examRoom.leave(7);
        Assert.assertEquals(7, examRoom.seat());
        Assert.assertEquals(0, examRoom.seat());
        Assert.assertEquals(5, examRoom.seat());
        Assert.assertEquals(1, examRoom.seat());
        Assert.assertEquals(2, examRoom.seat());
        Assert.assertEquals(4, examRoom.seat());
        Assert.assertEquals(6, examRoom.seat());
    }

    @Test
    public void test0856() {
        P0856ScoreOfParentheses solver = new P0856ScoreOfParentheses();
        Assert.assertEquals(1, solver.scoreOfParentheses("()"));
        Assert.assertEquals(2, solver.scoreOfParentheses("(())"));
        Assert.assertEquals(2, solver.scoreOfParentheses("()()"));
        Assert.assertEquals(6, solver.scoreOfParentheses("(()(()))"));
    }
}
