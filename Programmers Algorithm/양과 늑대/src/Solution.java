//
// DFS(양과 늑대)
// https://programmers.co.kr/learn/courses/30/lessons/92343?language=java
// Created by hyungwook on 2022/01/23.
//

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    int[] info;
    int[][] edges;
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    int answer = 0;

    public int solution(int[] info, int[][] edges) {
        this.info = info;
        this.edges = edges;

        for (int[] edge : edges) {
            if (map.containsKey(edge[0])) {
                map.get(edge[0]).add(edge[1]);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(edge[1]);
                map.put(edge[0], list);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(0, 0, 0, list);

        return answer;
    }

    private void dfs(int s, int w, int idx, ArrayList<Integer> list) {
        if (info[idx] == 0) {
            s++;
        } else {
            w++;
        }

        if (w >= s) {
            return;
        }

        answer = Math.max(answer, s);
        ArrayList<Integer> goTo = new ArrayList<>(list);

        if (map.containsKey(idx)) {
            goTo.addAll(map.get(idx));
        }

        goTo.remove(Integer.valueOf(idx));

        for (Integer integer : goTo) {
            dfs(s, w, integer, goTo);
        }
    }
}