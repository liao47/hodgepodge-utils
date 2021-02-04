package com.github.liao47.leetcode;

import com.github.liao47.leetcode.utils.UnionFind;

import java.util.*;

/**
 * 1202. 交换字符串中的元素
 * 
 * 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
 *
 * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
 *
 * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
 *
 *  
 *
 * 示例 1:
 *
 * 输入：s = "dcab", pairs = [[0,3],[1,2]]
 * 输出："bacd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[1] 和 s[2], s = "bacd"
 * 示例 2：
 *
 * 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * 输出："abcd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[0] 和 s[2], s = "acbd"
 * 交换 s[1] 和 s[2], s = "abcd"
 * 示例 3：
 *
 * 输入：s = "cba", pairs = [[0,1],[1,2]]
 * 输出："abc"
 * 解释：
 * 交换 s[0] 和 s[1], s = "bca"
 * 交换 s[1] 和 s[2], s = "bac"
 * 交换 s[0] 和 s[1], s = "abc"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 10^5
 * 0 <= pairs.length <= 10^5
 * 0 <= pairs[i][0], pairs[i][1] < s.length
 * s 中只含有小写英文字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-string-with-swaps
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liao47
 * @date 2021/1/11 13:55
 */
public class P1202SmallestStringWithSwaps {
    public String smallestStringWithSwaps1(String s, List<List<Integer>> pairs) {
        Queue<List<Integer>> listQueue = new LinkedList<>();
        for (List<Integer> pair : pairs) {
            listQueue.offer(pair);
        }
        char[] chars = s.toCharArray();
        while (!listQueue.isEmpty()) {
            Set<Integer> set = new TreeSet<>();
            dfs(listQueue, set, listQueue.poll());

            Queue<Character> queue = new PriorityQueue<>();
            for (Integer integer : set) {
                queue.offer(chars[integer]);
            }
            for (Integer integer : set) {
                chars[integer] = queue.poll();
            }
        }
        return new String(chars);
    }

    private void dfs(Queue<List<Integer>> listQueue, Set<Integer> set, List<Integer> pair) {
        set.addAll(pair);
        int size = listQueue.size();
        while (size > 0 && !listQueue.isEmpty()) {
            List<Integer> item = listQueue.poll();
            if (!Collections.disjoint(set, item)) {
                dfs(listQueue, set, item);
            } else {
                listQueue.offer(item);
            }
            size--;
        }
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind unionFind = new UnionFind(s.length());
        for (List<Integer> pair : pairs) {
            unionFind.union(pair.get(0), pair.get(1));
        }
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.computeIfAbsent(unionFind.find(i), k -> new PriorityQueue<>()).offer(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(map.get(unionFind.find(i)).poll());
        }
        return sb.toString();
    }
}
