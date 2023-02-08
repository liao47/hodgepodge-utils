package com.github.liao47.leetcode;

import java.util.*;

/**
 * 1604. 警告一小时内使用相同员工卡大于等于三次的人
 * @author liaoshiqing
 * @date 2023/2/7 17:47
 */
public class P1604 {

    public List<String> alertNames1(String[] keyName, String[] keyTime) {
        int n = keyName.length;
        int[] times = new int[n];
        Integer[] indexes = new Integer[n];
        for (int i = 0; i < n; i++) {
            String time = keyTime[i];
            int hour = (time.charAt(0) - '0') * 10 + time.charAt(1) - '0';
            int minute = (time.charAt(3) - '0') * 10 + time.charAt(4);
            times[i] = hour * 60 + minute;
            indexes[i] = i;
        }
        Arrays.sort(indexes, Comparator.comparingInt(a -> times[a]));

        Map<String, int[]> map = new HashMap<>(n);
        List<String> list = new ArrayList<>();
        for (Integer index : indexes) {
            String name = keyName[index];
            int time = times[index];
            int[] arr = map.computeIfAbsent(name, t -> new int[2]);
            if (arr[0] == -1) {
                continue;
            }
            if (arr[0] == 0) {
                arr[0] = time;
            } else if (arr[1] == 0) {
                arr[1] = time;
            } else if (time - arr[0] <= 60) {
                list.add(name);
                arr[0] = -1;
            } else {
                arr[0] = arr[1];
                arr[1] = time;
            }
        }
        Collections.sort(list);
        return list;
    }

    public List<String> alertNames2(String[] keyName, String[] keyTime) {
        int n = keyName.length;
        Map<String, List<Integer>> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            List<Integer> list = map.computeIfAbsent(name, t -> new ArrayList<>());
            int hour = (time.charAt(0) - '0') * 10 + time.charAt(1) - '0';
            int minute = (time.charAt(3) - '0') * 10 + time.charAt(4) - '0';
            list.add(hour * 60 + minute);
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            entry.getValue().sort(null);
            for (int i = 2; i < entry.getValue().size(); i++) {
                if (entry.getValue().get(i) - entry.getValue().get(i - 2) <= 60) {
                    list.add(entry.getKey());
                    break;
                }
            }
        }
        list.sort(null);
        return list;
    }

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        int n = keyName.length;
        Map<String, PriorityQueue<Integer>> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            PriorityQueue<Integer> queue = map.computeIfAbsent(name, t -> new PriorityQueue<>());
            int hour = (time.charAt(0) - '0') * 10 + time.charAt(1) - '0';
            int minute = (time.charAt(3) - '0') * 10 + time.charAt(4) - '0';
            queue.offer(hour * 60 + minute);
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, PriorityQueue<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() <= 2) {
                continue;
            }
            int t1 = entry.getValue().poll();
            int t2 = entry.getValue().poll();
            while (!entry.getValue().isEmpty()) {
                int t3 = entry.getValue().poll();
                if (t3 - t1 <= 60) {
                    list.add(entry.getKey());
                    break;
                }
                t1 = t2;
                t2 = t3;
            }
        }
        list.sort(null);
        return list;
    }
}
