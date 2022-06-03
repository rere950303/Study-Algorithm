//
// BFS, Union Find, Graph(Is Graph Bipartite?)
// https://leetcode.com/problems/is-graph-bipartite/
// Created by hyungwook on 2022/06/01.
//

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] check = new int[n];

        for (int i = 0; i < n; i++) {
            if (check[i] == 0 && graph[i].length != 0) {
                check[i] = -1;
                if (!bfs(check, graph, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean bfs(int[] check, int[][] graph, int node) {
        int flag = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Integer from = queue.poll();

                for (int to : graph[from]) {
                    if (check[from] == check[to]) {
                        return false;
                    }
                    if (check[to] == 0) {
                        check[to] = flag;
                        queue.add(to);
                    }
                }
            }

            flag *= -1;
        }

        return true;
    }
}