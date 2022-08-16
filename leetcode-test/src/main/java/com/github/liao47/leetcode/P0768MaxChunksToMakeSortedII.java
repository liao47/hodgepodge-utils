package com.github.liao47.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 768. 最多能完成排序的块 II
 *
 * 这个问题和“最多能完成排序的块”相似，但给定数组中的元素可以重复，输入数组最大长度为2000，其中的元素最大为10**8。
 *
 * arr是一个可能包含重复元素的整数数组，我们将这个数组分割成几个“块”，并将这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
 *
 * 我们最多能将数组分成多少块？
 *
 * 示例 1:
 *
 * 输入: arr = [5,4,3,2,1]
 * 输出: 1
 * 解释:
 * 将数组分成2块或者更多块，都无法得到所需的结果。
 * 例如，分成 [5, 4], [3, 2, 1] 的结果是 [4, 5, 1, 2, 3]，这不是有序的数组。 
 * 示例 2:
 *
 * 输入: arr = [2,1,3,4,4]
 * 输出: 4
 * 解释:
 * 我们可以把它分成两块，例如 [2, 1], [3, 4, 4]。
 * 然而，分成 [2, 1], [3], [4], [4] 可以得到最多的块数。 
 * 注意:
 *
 * arr的长度在[1, 2000]之间。
 * arr[i]的大小在[0, 10**8]之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/max-chunks-to-make-sorted-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/8/16 13:57
 */
public class P0768MaxChunksToMakeSortedII {
    public int maxChunksToSorted1(int[] arr) {
        int[] sorted = new int[arr.length];
        System.arraycopy(arr, 0, sorted, 0, arr.length);
        Arrays.sort(sorted);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            sum -= sorted[i];
            if (sum == 0) {
                count++;
            }
        }
        return count;
    }

    public int maxChunksToSorted2(int[] arr) {
        int n = arr.length;
        //前缀的最大值
        int[] prefixMax = new int[n];
        //后缀的最小值
        int[] suffixMin = new int[n];
        prefixMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], arr[i]);
        }
        suffixMin[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], arr[i]);
        }
        //最小一个块
        int ans = 1;
        for (int i = 0; i < n - 1; i++) {
            //前缀的最大值，小于等于后缀的最小值，则这里可以划分
            if (prefixMax[i] <= suffixMin[i + 1]) {
                ans++;
            }
        }
        return ans;
    }

    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : arr) {
            if (stack.isEmpty() || num >= stack.peek()) {
                stack.push(num);
            } else {
                int mx = stack.poll();
                while (!stack.isEmpty() && stack.peek() > num) {
                    stack.poll();
                }
                stack.push(mx);
            }
        }
        return stack.size();
    }
}
