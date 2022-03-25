//
// DFS, Matrix(Count Servers that Communicate)
// https://leetcode.com/problems/count-servers-that-communicate/
// Created by hyungwook on 2022/03/24.
//

public class Solution {

    int m;
    int n;
    int[][] grid;

    public int countServers(int[][] grid) {
        this.grid = grid;
        int answer = 0;
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    int count = dfs(i, j);

                    if (count > 1) {
                        answer += count;
                    }
                }
            }
        }

        return answer;
    }

    private int dfs(int r, int c) {
        int count = 1;

        for (int i = 0; i < m; i++) {
            if (grid[i][c] == 1) {
                grid[i][c] = 0;
                count += dfs(i, c);
            }
        }
        for (int i = 0; i < n; i++) {
            if (grid[r][i] == 1) {
                grid[r][i] = 0;
                count += dfs(r, i);
            }
        }

        return count;
    }
}