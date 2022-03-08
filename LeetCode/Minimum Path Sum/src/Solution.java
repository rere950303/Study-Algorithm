//
// DP, Matrix(Minimum Path Sum)
// https://leetcode.com/problems/minimum-path-sum/
// Created by hyungwook on 2022/03/08.
//

public class Solution {

    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int min;

                if (i == 0 && j == 0) {
                    min = 0;
                } else if (i == 0) {
                    min = grid[0][j - 1];
                } else if (j == 0) {
                    min = grid[i - 1][0];
                } else {
                    min = Math.min(grid[i - 1][j], grid[i][j - 1]);
                }

                grid[i][j] += min;
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }
}