package com.github.liao47.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1592. 重新排列单词间的空格
 * 
 * 给你一个字符串 text ，该字符串由若干被空格包围的单词组成。每个单词由一个或者多个小写英文字母组成，并且两个单词之间至少存在一个空格。题目测试用例保证 text 至少包含一个单词 。
 *
 * 请你重新排列空格，使每对相邻单词之间的空格数目都 相等 ，并尽可能 最大化 该数目。如果不能重新平均分配所有空格，请 将多余的空格放置在字符串末尾 ，这也意味着返回的字符串应当与原 text 字符串的长度相等。
 *
 * 返回 重新排列空格后的字符串 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：text = "  this   is  a sentence "
 * 输出："this   is   a   sentence"
 * 解释：总共有 9 个空格和 4 个单词。可以将 9 个空格平均分配到相邻单词之间，相邻单词间空格数为：9 / (4-1) = 3 个。
 * 示例 2：
 *
 * 输入：text = " practice   makes   perfect"
 * 输出："practice   makes   perfect "
 * 解释：总共有 7 个空格和 3 个单词。7 / (3-1) = 3 个空格加上 1 个多余的空格。多余的空格需要放在字符串的末尾。
 * 示例 3：
 *
 * 输入：text = "hello   world"
 * 输出："hello   world"
 * 示例 4：
 *
 * 输入：text = "  walks  udp package   into  bar a"
 * 输出："walks  udp  package  into  bar  a "
 * 示例 5：
 *
 * 输入：text = "a"
 * 输出："a"
 *  
 *
 * 提示：
 *
 * 1 <= text.length <= 100
 * text 由小写英文字母和 ' ' 组成
 * text 中至少包含一个单词
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/rearrange-spaces-between-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/9/7 9:35
 */
public class P1592RearrangeSpacesBetweenWords {
    public String reorderSpaces1(String text) {
        String[] arr = text.trim().split(" +");
        int divisor = arr.length - 1;
        if (divisor == 0) {
            return arr[0] + text.replace(arr[0], "");
        }

        int spaces = text.length();
        for (String s : arr) {
            spaces -= s.length();
        }

        char[] chars = new char[spaces / divisor];
        Arrays.fill(chars, ' ');
        String join = String.join(new String(chars), arr);

        chars = new char[spaces % divisor];
        Arrays.fill(chars, ' ');
        return join + new String(chars);
    }

    public String reorderSpaces2(String text) {
        StringBuilder sb = new StringBuilder();
        int spaces = 0;
        List<String> list = new ArrayList<>();
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                spaces++;
                if (sb.length() > 0) {
                    list.add(sb.toString());
                    sb = new StringBuilder();
                }
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) {
            list.add(sb.toString());
        }
        int divisor = list.size() - 1;
        if (divisor == 0) {
            return list.get(0) + text.replace(list.get(0), "");
        }
        char[] chars = new char[spaces / divisor];
        Arrays.fill(chars, ' ');
        String join = String.join(new String(chars), list);

        chars = new char[spaces % divisor];
        Arrays.fill(chars, ' ');
        return join + new String(chars);
    }

    public String reorderSpaces3(String text) {
        StringBuilder sb = new StringBuilder();
        int spaces = 0;
        List<Integer> indexes = new ArrayList<>();
        char prevChar = ' ';
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                spaces++;
                if (prevChar != ' ') {
                    indexes.add(sb.length());
                }
            } else {
                sb.append(c);
            }
            prevChar = c;
        }

        int divisor = prevChar == ' ' ? indexes.size() - 1 : indexes.size();
        int tailCnt = spaces;
        if (divisor != 0) {
            int perCnt = spaces / divisor;
            tailCnt = spaces % divisor;
            char[] perSpace = new char[perCnt];
            Arrays.fill(perSpace, ' ');
            for (int i = 0; i < divisor; i++) {
                sb.insert(i * perCnt + indexes.get(i), perSpace);
            }
        }
        while (tailCnt-- > 0) {
            sb.append(' ');
        }
        return sb.toString();
    }

    public String reorderSpaces(String text) {
        int space = 0;
        int divisor = 0;
        char prevChar = ' ';
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                space++;
                if (prevChar != ' ') {
                    divisor++;
                }
            }
            prevChar = c;
        }
        if (prevChar == ' ') {
            divisor--;
        }

        char[] chars = new char[text.length()];
        int index = 0;
        int perCnt = divisor == 0 ? 0 : space / divisor;
        prevChar = ' ';
        for (char c : text.toCharArray()) {
            if (c != ' ') {
                chars[index++] = c;
            } else if (prevChar != ' ') {
                for (int i = 0; i < perCnt && index < text.length(); i++) {
                    chars[index++] = ' ';
                }
            }
            prevChar = c;
        }
        while (index < text.length()) {
            chars[index++] = ' ';
        }
        return new String(chars);
    }
}
