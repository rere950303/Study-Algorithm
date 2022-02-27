//
// BFS, DP([카카오 인턴] 동굴 탐험)
// https://programmers.co.kr/learn/courses/30/lessons/67260#
// Created by hyungwook on 2022/02/26.
//

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public boolean solution(int n, int[][] path, int[][] order) {
        int[] pre = new int[n];
        for (int[] ints : order) {
            pre[ints[1]] = ints[0];
        }

        List<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] ints : path) {
            list.get(ints[0]).add(ints[1]);
            list.get(ints[1]).add(ints[0]);
        }

        boolean[] visited = new boolean[n];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        int[] preSatisfied = new int[n];
        visited[0] = true;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();

            if (!visited[pre[node]]) {
                preSatisfied[pre[node]] = node;
                continue;
            }
            for (Integer child : list.get(node)) {
                if (!visited[child]) {
                    visited[child] = true;
                    queue.add(child);
                }
            }
            if (preSatisfied[node] != 0) {
                visited[node] = true;
                queue.add(preSatisfied[node]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }
}