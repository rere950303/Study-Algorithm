//
// Union Find, Graph, BFS, DFS(Redundant Connection)
// https://leetcode.com/problems/redundant-connection/
// Created by hyungwook on 2022/09/24.
//

import java.util.stream.IntStream;

public class Solution {

    int[] boss;

    public int[] findRedundantConnection(int[][] edges) {
        int[] answer = new int[2];
        int n = edges.length;
        boss = new int[n + 1];
        IntStream.rangeClosed(0, n).forEach(i -> boss[i] = i);

        for (int[] edge : edges) {
            if (find(edge[0]) != find(edge[1])) {
                union(edge[0], edge[1]);
            } else {
                answer = edge;
            }
        }

        return answer;
    }

    private int find(int a) {
        if (boss[a] == a) {
            return a;
        }

        return boss[a] = find(boss[a]);
    }

    private void union(int a, int b) {
        int aBoss = find(a);
        int bBoss = find(b);

        if (aBoss != bBoss) {
            boss[aBoss] = bBoss;
        }
    }
}
