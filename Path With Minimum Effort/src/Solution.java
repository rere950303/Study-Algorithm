//
// Dijkstra, Heap, Matrix, DFS(Path With Minimum Effort)
// https://leetcode.com/problems/path-with-minimum-effort/
// Created by hyungwook on 2022/03/01.
//

import java.util.PriorityQueue;

public class Solution {

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((i1, i2) -> i1[2] - i2[2]);
        queue.add(new int[]{0, 0, 0});
        boolean[][] check = new boolean[m][n];
        int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int r = poll[0];
            int c = poll[1];

            if (check[r][c]) {
                continue;
            }
            check[r][c] = true;

            if (poll[0] == m - 1 && poll[1] == n - 1) {
                return poll[2];
            }

            for (int i = 0; i < 4; i++) {
                int rn = r + dir[i][0];
                int cn = c + dir[i][1];

                if (rn >= 0 && rn < m && cn >= 0 && cn < n && !check[rn][cn]) {
                    queue.add(new int[]{rn, cn, Math.max(poll[2], Math.abs(heights[r][c] - heights[rn][cn]))});
                }
            }
        }

        return 0;
    }
}