//
// DFS, Matrix(Detect Cycles in 2D Grid)
// https://leetcode.com/problems/detect-cycles-in-2d-grid/
// Created by hyungwook on 2022/03/30.
//

public class Solution {

    int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int m;
    int n;
    int count = 1;
    int[][] isVisit;

    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        isVisit = new int[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n - 1; c++) {
                if (isVisit[r][c] == 0 && isCycle(grid, r, c, r, c)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isCycle(char[][] grid, int r, int c, int prevR, int prevC) {
        if (isVisit[r][c] - isVisit[prevR][prevC] >= 3) {
            return true;
        }
        if (isVisit[r][c] != 0) {
            return false;
        }

        isVisit[r][c] = count++;

        for (int i = 0; i < 4; i++) {
            int rn = r + dir[i][0];
            int cn = c + dir[i][1];

            if (rn >= 0 && rn < m && cn >= 0 && cn < n && grid[rn][cn] == grid[r][c] && isCycle(grid, rn, cn, r, c)) {
                return true;
            }
        }

        return false;
    }
}