package com.github.liao47.leetcode;

import java.util.Arrays;

/**
 * 135. 分发糖果
 *
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * 示例 1:
 *
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2:
 *
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liao47
 * @date 2020/12/24 9:58
 */
public class P0135Candy {
    public int candy2(int[] ratings) {
        int[] candy = new int[ratings.length];
        candy[0] = 1;
        int current = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                current++;
                candy[i] = current;
            } else {
                candy[i] = 1;
                if (ratings[i] < ratings[i - 1] && current == 1) {
                    for (int j = i - 1; j >= 0 && ratings[j] > ratings[j + 1] && candy[j] <= candy[j + 1]; j--) {
                        candy[j]++;
                    }
                }
                current = 1;
            }
        }
        return Arrays.stream(candy).sum();
    }

    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            } else {
                candy[i] = 1;
            }
        }
        int sum = 0;
        int add = 0;
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i < ratings.length - 1 && ratings[i] > ratings[i + 1]) {
                add++;
            } else {
                add = 1;
            }
            sum += Math.max(add, candy[i]);
        }
        return sum;
    }
}
