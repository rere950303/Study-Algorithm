//
// DFS, BFS(Shortest Bridge)
// https://leetcode.com/problems/shortest-bridge/
// Created by hyungwook on 2022/03/14.
//

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int length;
    int[][] grid;
    Queue<int[]> queue = new LinkedList<>();

    public int shortestBridge(int[][] grid) {
        this.length = grid.length;
        this.grid = grid;
        boolean flag = false;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (grid[i][j] == 1) {
                    flag = true;
                    dfs(i, j);
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        int answer = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int rn = poll[0] + dir[j][0];
                    int cn = poll[1] + dir[j][1];

                    if (rn >= 0 && rn < length && cn >= 0 && cn < length) {
                        if (grid[rn][cn] == 1) {
                            return answer;
                        } else if (grid[rn][cn] == 0) {
                            grid[rn][cn] = 2;
                            queue.add(new int[]{rn, cn});
                        }
                    }
                }
            }

            answer++;
        }

        return answer;
    }

    private void dfs(int r, int c) {
        grid[r][c] = 2;
        queue.add(new int[]{r, c});

        for (int i = 0; i < 4; i++) {
            int rn = r + dir[i][0];
            int cn = c + dir[i][1];

            if (rn >= 0 && rn < length && cn >= 0 && cn < length && grid[rn][cn] == 1) {
                dfs(rn ,cn);
            }
        }
    }
}