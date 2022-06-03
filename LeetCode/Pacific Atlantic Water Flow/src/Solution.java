//
// BFS, Matrix(Pacific Atlantic Water Flow)
// https://leetcode.com/problems/pacific-atlantic-water-flow/
// Created by hyungwook on 2022/05/30.
//

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int m;
    int n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;

        boolean[][] pacificCheck = new boolean[m][n];
        boolean[][] atlanticCheck = new boolean[m][n];

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            pacificCheck[i][0] = true;
            pacificQueue.add(new int[]{i, 0});

            atlanticCheck[i][n - 1] = true;
            atlanticQueue.add(new int[]{i, n - 1});
        }
        for (int i = 0; i < n; i++) {
            pacificCheck[0][i] = true;
            pacificQueue.add(new int[]{0, i});

            atlanticCheck[m - 1][i] = true;
            atlanticQueue.add(new int[]{m - 1, i});
        }

        bfs(pacificCheck, pacificQueue, heights);
        bfs(atlanticCheck, atlanticQueue, heights);

        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificCheck[i][j] && atlanticCheck[i][j]) {
                    answer.add(List.of(i, j));
                }
            }
        }

        return answer;
    }

    private void bfs(boolean[][] check, Queue<int[]> queue, int[][] heights) {
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int r = poll[0];
                int c = poll[1];

                for (int j = 0; j < 4; j++) {
                    int rn = r + dir[j][0];
                    int cn = c + dir[j][1];

                    if (rn >= 0 && rn < m && cn >= 0 && cn < n && !check[rn][cn] && heights[r][c] <= heights[rn][cn]) {
                        check[rn][cn] = true;
                        queue.add(new int[]{rn, cn});
                    }
                }
            }
        }
    }
}