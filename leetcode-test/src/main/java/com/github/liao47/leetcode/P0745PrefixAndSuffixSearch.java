package com.github.liao47.leetcode;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * 745. 前缀和后缀搜索
 *
 * 设计一个包含一些单词的特殊词典，并能够通过前缀和后缀来检索单词。
 *
 * 实现 WordFilter 类：
 *
 * WordFilter(string[] words) 使用词典中的单词 words 初始化对象。
 * f(string pref, string suff) 返回词典中具有前缀 prefix 和后缀 suff 的单词的下标。如果存在不止一个满足要求的下标，返回其中 最大的下标 。如果不存在这样的单词，返回 -1 。
 *  
 *
 * 示例：
 *
 * 输入
 * ["WordFilter", "f"]
 * [[["apple"]], ["a", "e"]]
 * 输出
 * [null, 0]
 * 解释
 * WordFilter wordFilter = new WordFilter(["apple"]);
 * wordFilter.f("a", "e"); // 返回 0 ，因为下标为 0 的单词：前缀 prefix = "a" 且 后缀 suff = "e" 。
 *  
 * 提示：
 *
 * 1 <= words.length <= 10^4
 * 1 <= words[i].length <= 7
 * 1 <= pref.length, suff.length <= 7
 * words[i]、pref 和 suff 仅由小写英文字母组成
 * 最多对函数 f 执行 10^4 次调用
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/prefix-and-suffix-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/7/14 10:49
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class P0745PrefixAndSuffixSearch {
    public static class WordFilter1 {
        static class Node {
            Node[] next = new Node[26];
            List<Integer> indices = new ArrayList<>();
        }

        private final Node root;
        private final Node tail;

        public WordFilter1(String[] words) {
            root = new Node();
            tail = new Node();
            for (int i = 0; i < words.length; i++) {
                Node prefix = root;
                Node suffix = tail;
                char[] arr = words[i].toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    int idx = arr[j] - 'a';
                    if (prefix.next[idx] == null) {
                        prefix.next[idx] = new Node();
                    }
                    prefix = prefix.next[idx];
                    prefix.indices.add(i);

                    idx = arr[arr.length - j - 1] - 'a';
                    if (suffix.next[idx] == null) {
                        suffix.next[idx] = new Node();
                    }
                    suffix = suffix.next[idx];
                    suffix.indices.add(i);
                }
            }
        }

        public int f(String pref, String suff) {
            Node node = root;
            for (char c : pref.toCharArray()) {
                node = node.next[c - 'a'];
                if (node == null) {
                    return -1;
                }
            }
            List<Integer> prefixIndices = node.indices;

            node = tail;
            char[] arr = suff.toCharArray();
            for (int i = arr.length - 1; i >= 0; i--) {
                node = node.next[arr[i] - 'a'];
                if (node == null) {
                    return -1;
                }
            }
            List<Integer> suffixIndices = node.indices;

            int i = prefixIndices.size() - 1;
            int j = suffixIndices.size() - 1;
            while (i >= 0 && j >= 0) {
                int a = prefixIndices.get(i);
                int b = suffixIndices.get(j);
                if (a == b) {
                    return a;
                } else if (a > b) {
                    i--;
                } else {
                    j--;
                }
            }
            return -1;
        }
    }

    public static class WordFilter2 {
        private final Map<String, List<Integer>> prefixMap;
        private final Map<String, List<Integer>> suffixMap;

        public WordFilter2(String[] words) {
            this.prefixMap = new HashMap<>();
            this.suffixMap = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                StringBuilder prefix = new StringBuilder();
                StringBuilder suffix = new StringBuilder();
                char[] arr = words[i].toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    prefix.append(arr[j]);
                    prefixMap.computeIfAbsent(prefix.toString(), t -> new ArrayList<>()).add(i);

                    suffix.insert(0, arr[arr.length - j - 1]);
                    suffixMap.computeIfAbsent(suffix.toString(), t -> new ArrayList<>()).add(i);
                }
            }
        }

        public int f(String pref, String suff) {
            List<Integer> prefix = prefixMap.get(pref);
            List<Integer> suffix = suffixMap.get(suff);
            int i = prefix == null ? -1 : prefix.size() - 1;
            int j = suffix == null ? -1 : suffix.size() - 1;
            while (i >= 0 && j >= 0) {
                int a = prefix.get(i);
                int b = suffix.get(j);
                if (a == b) {
                    return a;
                } else if (a > b) {
                    i--;
                } else {
                    j--;
                }
            }
            return -1;
        }
    }

    public static class WordFilter {
        static class Node {
            Node[] next;
            List<long[]> indices;

            public Node() {
                this.next = new Node[26];
                this.indices = new ArrayList<>();
            }
        }

        private final Node root;
        private final Node tail;

        public WordFilter(String[] words) {
            root = new Node();
            tail = new Node();
            for (int i = 0; i < words.length; i++) {
                Node prefix = root;
                Node suffix = tail;
                int index = i / 64;
                long val = 1L << i % 64;
                char[] arr = words[i].toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    prefix = nextNode(prefix, arr[j], index, val);
                    suffix = nextNode(suffix, arr[arr.length - j - 1], index, val);
                }
            }
        }

        public int f(String pref, String suff) {
            Node node = root;
            for (char c : pref.toCharArray()) {
                node = node.next[c - 'a'];
                if (node == null) {
                    return -1;
                }
            }
            List<long[]> prefixIndices = node.indices;

            node = tail;
            char[] arr = suff.toCharArray();
            for (int i = arr.length - 1; i >= 0; i--) {
                node = node.next[arr[i] - 'a'];
                if (node == null) {
                    return -1;
                }
            }
            List<long[]> suffixIndices = node.indices;

            int i = prefixIndices.size() - 1;
            int j = suffixIndices.size() - 1;
            while (i >= 0 && j >= 0) {
                long[] a = prefixIndices.get(i);
                long[] b = suffixIndices.get(j);
                if (a[0] == b[0]) {
                    long val = a[1] & b[1];
                    if (val != 0) {
                        int idx = 0;
                        int k = 32;
                        while (k != 0) {
                            if (val >> k != 0) {
                                idx += k;
                                val >>= k;
                            }
                            k >>= 1;
                        }
                        return (int) (64 * a[0] + idx);
                    }
                    i--;
                    j--;
                } else if (a[0] > b[0]) {
                    i--;
                } else {
                    j--;
                }
            }
            return -1;
        }

        private Node nextNode(Node node, char c, int index, long val) {
            int idx = c - 'a';
            if (node.next[idx] == null) {
                node.next[idx] = new Node();
            }
            node = node.next[idx];

            long[] arr = node.indices.isEmpty() ? null : node.indices.get(node.indices.size() - 1);
            if (arr != null && arr[0] == index) {
                arr[1] |= val;
            } else {
                node.indices.add(new long[]{index, val});
            }
            return node;
        }
    }
}
