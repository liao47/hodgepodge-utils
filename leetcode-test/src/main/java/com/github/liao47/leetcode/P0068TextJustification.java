package com.github.liao47.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 68. 文本左右对齐
 *
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 *
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 *
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 *
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *
 * 说明:
 *
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * 示例:
 *
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 示例 2:
 *
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。       
 *      第二行同样为左对齐，这是因为这行只包含一个单词。
 * 示例 3:
 *
 * 输入:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/text-justification
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2021/9/9 11:16
 */
public class P0068TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        String[] spaces = new String[maxWidth];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxWidth; i++) {
            spaces[i] = sb.toString();
            sb.append(" ");
        }

        List<String> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        int width = 0;
        for (String word : words) {
            if (width + word.length() + list.size() > maxWidth) {
                int remainder = maxWidth - width;
                int pad = 0;
                if (remainder != 0 && list.size() > 1) {
                    pad = remainder / (list.size() - 1);
                    remainder %= list.size() - 1;
                }

                StringBuilder line = new StringBuilder(list.get(0));
                for (int i = 1; i < list.size(); i++) {
                    if (remainder > 0) {
                        line.append(spaces[pad + 1]);
                        remainder--;
                    } else {
                        line.append(spaces[pad]);
                    }
                    line.append(list.get(i));
                }
                line.append(spaces[remainder]);
                ans.add(line.toString());

                list = new ArrayList<>();
                width = 0;
            }

            list.add(word);
            width += word.length();
        }
        if (!list.isEmpty()) {
            StringBuilder line = new StringBuilder();
            width = 0;
            for (String str : list) {
                if (line.length() > 0) {
                    line.append(spaces[1]);
                    width++;
                }
                line.append(str);
                width += str.length();
            }
            line.append(spaces[maxWidth - width]);
            ans.add(line.toString());
        }
        return ans;
    }
}
