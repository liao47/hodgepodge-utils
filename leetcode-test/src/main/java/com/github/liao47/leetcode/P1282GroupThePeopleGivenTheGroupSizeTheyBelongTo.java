package com.github.liao47.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1282. 用户分组
 *
 * 有 n 个人被分成数量未知的组。每个人都被标记为一个从 0 到 n - 1 的唯一ID 。
 *
 * 给定一个整数数组 groupSizes ，其中 groupSizes[i] 是第 i 个人所在的组的大小。例如，如果 groupSizes[1] = 3 ，则第 1 个人必须位于大小为 3 的组中。
 *
 * 返回一个组列表，使每个人 i 都在一个大小为 groupSizes[i] 的组中。
 *
 * 每个人应该 恰好只 出现在 一个组 中，并且每个人必须在一个组中。如果有多个答案，返回其中 任何 一个。可以 保证 给定输入 至少有一个 有效的解。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：groupSizes = [3,3,3,3,3,1,3]
 * 输出：[[5],[0,1,2],[3,4,6]]
 * 解释：
 * 第一组是 [5]，大小为 1，groupSizes[5] = 1。
 * 第二组是 [0,1,2]，大小为 3，groupSizes[0] = groupSizes[1] = groupSizes[2] = 3。
 * 第三组是 [3,4,6]，大小为 3，groupSizes[3] = groupSizes[4] = groupSizes[6] = 3。 
 * 其他可能的解决方案有 [[2,1,6],[5],[0,4,3]] 和 [[5],[0,6,2],[4,3,1]]。
 * 示例 2：
 *
 * 输入：groupSizes = [2,1,3,3,3,2]
 * 输出：[[1],[0,5],[2,3,4]]
 *  
 *
 * 提示：
 *
 * groupSizes.length == n
 * 1 <= n <= 500
 * 1 <= groupSizes[i] <= n
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/group-the-people-given-the-group-size-they-belong-to
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/8/12 9:16
 */
public class P1282GroupThePeopleGivenTheGroupSizeTheyBelongTo {
    public List<List<Integer>> groupThePeople1(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>(500);
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> list = map.getOrDefault(groupSizes[i], new ArrayList<>());
            list.add(i);
            if (list.size() == groupSizes[i]) {
                result.add(list);
                map.remove(groupSizes[i]);
            } else {
                map.put(groupSizes[i], list);
            }
        }
        return result;
    }

    public List<List<Integer>> groupThePeople2(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer>[] arr = new List[500];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < groupSizes.length; i++) {
            arr[groupSizes[i]].add(i);
            if (arr[groupSizes[i]].size() == groupSizes[i]) {
                result.add(arr[groupSizes[i]]);
                arr[groupSizes[i]] = new ArrayList<>();
            }
        }
        return result;
    }

    public List<List<Integer>> groupThePeople3(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>(500);
        for (int i = 0; i < groupSizes.length; i++) {
            map.computeIfAbsent(groupSizes[i], t -> new ArrayList<>()).add(i);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int index = 0;
            while (index < entry.getValue().size()) {
                result.add(entry.getValue().subList(index, index += entry.getKey()));
            }
        }
        return result;
    }

    public List<List<Integer>> groupThePeople4(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        int[] indexes = new int[500];
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            List<Integer> list;
            if (indexes[size] == 0) {
                list = new ArrayList<>();
                result.add(list);
                indexes[size] = result.size();
            } else {
                list = result.get(indexes[size] - 1);
            }
            list.add(i);
            if (list.size() == size) {
                indexes[size] = 0;
            }
        }
        return result;
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (groupSizes[i] == 0) {
                continue;
            }
            List<Integer> list = new ArrayList<>();
            result.add(list);
            list.add(i);
            int size = groupSizes[i] - 1;
            for (int j = i + 1; j < groupSizes.length && size > 0; j++) {
                if (groupSizes[j] == groupSizes[i]) {
                    list.add(j);
                    groupSizes[j] = 0;
                    size--;
                }
            }
        }
        return result;
    }
}
