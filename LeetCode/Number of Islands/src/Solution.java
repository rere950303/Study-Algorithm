//
// DFS, Matrix(Number of Islands)
// https://leetcode.com/problems/number-of-islands/
// Created by hyungwook on 2022/06/03.
//

public class Solution {

    int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int m;
    int n;

    public int numIslands(char[][] grid) {
        int answer = 0;
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    answer++;
                    dfs(grid, i, j);
                }
            }
        }

        return answer;
    }

    private void dfs(char[][] grid, int r, int c) {
        grid[r][c] = '0';

        for (int i = 0; i < 4; i++) {
            int rn = r + dir[i][0];
            int cn = c + dir[i][1];

            if (rn >= 0 && rn < m && cn >= 0 && cn < n && grid[rn][cn] == '1') {
                dfs(grid, rn, cn);
            }
        }
    }
}