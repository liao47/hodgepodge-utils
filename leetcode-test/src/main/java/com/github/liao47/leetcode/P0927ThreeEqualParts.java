package com.github.liao47.leetcode;

/**
 * 927. 三等分
 * 给定一个由 0 和 1 组成的数组 arr ，将数组分成  3 个非空的部分 ，使得所有这些部分表示相同的二进制值。
 *
 * 如果可以做到，请返回任何 [i, j]，其中 i+1 < j，这样一来：
 *
 * arr[0], arr[1], ..., arr[i] 为第一部分；
 * arr[i + 1], arr[i + 2], ..., arr[j - 1] 为第二部分；
 * arr[j], arr[j + 1], ..., arr[arr.length - 1] 为第三部分。
 * 这三个部分所表示的二进制值相等。
 * 如果无法做到，就返回 [-1, -1]。
 *
 * 注意，在考虑每个部分所表示的二进制时，应当将其看作一个整体。例如，[1,1,0] 表示十进制中的 6，而不会是 3。此外，前导零也是被允许的，所以 [0,1,1] 和 [1,1] 表示相同的值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [1,0,1,0,1]
 * 输出：[0,3]
 * 示例 2：
 *
 * 输入：arr = [1,1,0,1,1]
 * 输出：[-1,-1]
 * 示例 3:
 *
 * 输入：arr = [1,1,0,0,1]
 * 输出：[0,2]
 *  
 *
 * 提示：
 *
 * 3 <= arr.length <= 3 * 10^4
 * arr[i] 是 0 或 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/three-equal-parts
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/10/11 14:41
 */
public class P0927ThreeEqualParts {
    public int[] threeEqualParts(int[] arr) {
        int n = arr.length;
        int count = 0;
        for (int i : arr) {
            count += i;
        }
        if (count == 0) {
            return new int[]{0, n - 1};
        }
        if (count % 3 != 0) {
            return new int[]{-1, -1};
        }

        count /= 3;
        int[] indexes = new int[3];
        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            cnt += arr[i];
            if (cnt % count == 0 && arr[i] == 1) {
                indexes[3 - cnt / count] = i;
            }
        }
        while (indexes[2] < n) {
            if (arr[indexes[0]++] != arr[indexes[1]] || arr[indexes[1]++] != arr[indexes[2]++]) {
                return new int[]{-1, -1};
            }
        }
        return new int[]{indexes[0] - 1, indexes[1]};
    }

    public int[] threeEqualParts2(int[] arr) {
        int n = arr.length;
        int count = 0;
        for (int i : arr) {
            count += i;
        }
        if (count == 0) {
            return new int[]{0, n - 1};
        }
        if (count % 3 != 0) {
            return new int[]{-1, -1};
        }

        count /= 3;
        int first = -1;
        int second = -1;
        int third = -1;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += arr[i];
            if (cnt == 1 && first == -1) {
                first = i;
            } else if (cnt == count + 1 && second == -1) {
                second = i;
            } else if (cnt == 2 * count + 1 && third == -1) {
                third = i;
            }
        }
        while (third < n) {
            if (arr[third] != arr[second] || arr[second] != arr[first]) {
                return new int[]{-1, -1};
            }
            first++;
            second++;
            third++;
        }
        return new int[]{first - 1, second};
    }
}
