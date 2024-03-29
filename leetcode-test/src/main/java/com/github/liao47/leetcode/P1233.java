package com.github.liao47.leetcode;

import java.util.*;

/**
 * 1233. 删除子文件夹
 *
 * 你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。
 *
 * 如果文件夹 folder[i] 位于另一个文件夹 folder[j] 下，那么 folder[i] 就是 folder[j] 的 子文件夹 。
 *
 * 文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：'/' 后跟一个或者多个小写英文字母。
 *
 * 例如，"/leetcode" 和 "/leetcode/problems" 都是有效的路径，而空字符串和 "/" 不是。
 *
 *
 * 示例 1：
 *
 * 输入：folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
 * 输出：["/a","/c/d","/c/f"]
 * 解释："/a/b" 是 "/a" 的子文件夹，而 "/c/d/e" 是 "/c/d" 的子文件夹。
 * 示例 2：
 *
 * 输入：folder = ["/a","/a/b/c","/a/b/d"]
 * 输出：["/a"]
 * 解释：文件夹 "/a/b/c" 和 "/a/b/d" 都会被删除，因为它们都是 "/a" 的子文件夹。
 * 示例 3：
 *
 * 输入: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
 * 输出: ["/a/b/c","/a/b/ca","/a/b/d"]
 *
 *
 * 提示：
 *
 * 1 <= folder.length <= 4 * 10^4
 * 2 <= folder[i].length <= 100
 * folder[i] 只包含小写字母和 '/'
 * folder[i] 总是以字符 '/' 起始
 * 每个文件夹名都是 唯一 的
 * @author liaoshiqing
 * @date 2023/2/8 10:50
 */
public class P1233 {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, Comparator.comparingInt(String::length));
        List<String> res = new ArrayList<>();
        for(String path : folder) {
            boolean valid = true;
            for (String str : res) {
                if (path.startsWith(str + "/")) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                res.add(path);
            }
        }
        return res;
    }

    public List<String> removeSubfolders2(String[] folder) {
        Trie trie = new Trie();
        for (int i = 0; i < folder.length; i++) {
            String[] arr = folder[i].split("/");
            Trie node = trie;
            for (String val : arr) {
                node = node.next.computeIfAbsent(val, t -> new Trie());
                if (node.end != -1) {
                    node = null;
                    break;
                }
            }
            if (node != null) {
                node.end = i;
            }
        }

        Queue<Trie> queue = new LinkedList<>();
        queue.offer(trie);
        List<String> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            for (Map.Entry<String, Trie> entry : queue.poll().next.entrySet()) {
                if (entry.getValue().end == -1) {
                    queue.offer(entry.getValue());
                } else {
                    list.add(folder[entry.getValue().end]);
                }
            }
        }
        return list;
    }

    public static class Trie {
        int end;
        Map<String, Trie> next;

        public Trie() {
            end = -1;
            next = new HashMap<>();
        }
    }

    public static void main(String[] args) {
        List<Character> list = Arrays.asList('Q', 'W', 'E', 'R');
        for (Character c : list) {
            System.out.println(Integer.toBinaryString(c));
            int mod = c >> 1 & 3;
            System.out.println(c + ":" + mod);
        }
    }
}
