import com.github.liao47.leetcode.P1015SmallestIntegerDivisibleByK;
import com.github.liao47.leetcode.P1018BinaryPrefixDivisibleBy5;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2020/12/22 15:50
 */
public class LeetCode1010To1019Test {
    @Test
    public void test1015() {
        P1015SmallestIntegerDivisibleByK solver = new P1015SmallestIntegerDivisibleByK();
        assertEquals(1, solver.smallestRepunitDivByK(1));
        assertEquals(-1, solver.smallestRepunitDivByK(2));
        assertEquals(3, solver.smallestRepunitDivByK(3));
        assertEquals(6, solver.smallestRepunitDivByK(7));
        assertEquals(9, solver.smallestRepunitDivByK(9));
    }

    @Test
    public void test1018() {
        P1018BinaryPrefixDivisibleBy5 solver = new P1018BinaryPrefixDivisibleBy5();

        assertArrayEquals(new Boolean[]{true, false, false}, solver.prefixesDivBy5(new int[]{0, 1, 1}).toArray());
        assertArrayEquals(new Boolean[]{false, false, false}, solver.prefixesDivBy5(new int[]{1, 1, 1}).toArray());
        assertArrayEquals(new Boolean[]{true, false, false, false, true, false}, solver.prefixesDivBy5(new int[]{0, 1
                , 1, 1, 1, 1}).toArray());
        assertArrayEquals(new Boolean[]{false, false, false, false, false}, solver.prefixesDivBy5(new int[]{1, 1, 1,
                0, 1}).toArray());
        assertArrayEquals(new Boolean[]{false,false,false,false,false,false,false,false,false,false,false,false,false
                ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,
                false,false,true,false,false,true,true,true,true,false}, solver.prefixesDivBy5(new int[]{1,0,0,1,0,1,
                0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1}).toArray());
    }
}
