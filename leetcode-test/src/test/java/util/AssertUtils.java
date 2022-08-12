package util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author liaoshiqing
 * @date 2022/7/1 15:43
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AssertUtils {
    public static <E> void assertList(List<E> expected, List<E> actual, Comparator<E> comparator) {
        expected.sort(comparator);
        actual.sort(comparator);
        Assert.assertEquals(expected, actual);
    }

    public static <E extends Comparable<E>> void assertList(List<E> expected, List<E> actual) {
        assertList(expected, actual, Comparator.naturalOrder());
    }

    public static void assertArray(int[] expected, int[] actual) {
        Arrays.sort(expected);
        Arrays.sort(actual);
        Assert.assertArrayEquals(expected, actual);
    }
}
