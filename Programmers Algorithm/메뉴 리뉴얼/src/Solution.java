//
// DFS(메뉴 리뉴얼)
// https://programmers.co.kr/learn/courses/30/lessons/72411?language=java
// Created by hyungwook on 2021/11/05.
//

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {

    HashMap<String, Integer> map = new HashMap<>();
    int max = 0;
    PriorityQueue<String> queue = new PriorityQueue<>();

    public String[] solution(String[] orders, int[] course) {
        for (int i : course) {
            for (String order : orders) {
                char[] chars = order.toCharArray();
                Arrays.sort(chars);
                String s = new String(chars);
                dfs("", i, 0, s);
            }

            for (String s : map.keySet()) {
                if (map.get(s) == max && max > 1) {
                    queue.add(s);
                }
            }

            max = 0;
            map.clear();
        }

        int size = queue.size();
        String[] answer = new String[size];

        for (int i = 0; i < size; i++) {
            answer[i] = queue.poll();
        }

        return answer;
    }

    private void dfs(String string, int l, int start, String order) {
        if (string.length() == l) {
            map.put(string, map.getOrDefault(string, 0) + 1);
            max = Math.max(max, map.get(string));
        } else {
            for (int i = start; i < order.length(); i++) {
                dfs(string + order.charAt(i), l, i + 1, order);
            }
        }
    }
}