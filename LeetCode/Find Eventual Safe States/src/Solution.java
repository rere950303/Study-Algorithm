//
// DFS, Topological Sort(Find Eventual Safe States)
// https://leetcode.com/problems/find-eventual-safe-states/
// Created by hyungwook on 2022/05/19.
//

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> answer = new ArrayList<>();
        int[] check = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (dfs(i, check, graph)) {
                answer.add(i);
            }
        }

        return answer;
    }

    private boolean dfs(int node, int[] check, int[][] graph) {
        if (check[node] > 0) {
            return check[node] == 2;
        }

        check[node] = 1;
        for (int to : graph[node]) {
            if (check[to] == 2) {
                continue;
            }
            if (check[to] == 1 || !dfs(to, check, graph)) {
                return false;
            }
        }
        check[node] = 2;

        return true;
    }
}
