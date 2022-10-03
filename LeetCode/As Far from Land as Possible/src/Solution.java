//
// DP, Array(As Far from Land as Possible)
// https://leetcode.com/problems/as-far-from-land-as-possible/
// Created by hyungwook on 2022/09/24.
//

public class Solution {

    public int maxDistance(int[][] grid) {
        int sum = 0;
        int answer = Integer.MIN_VALUE;
        int n = grid.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += grid[i][j];
                if (grid[i][j] != 1) {
                    int top = i > 0 ? dp[i - 1][j] : 2 * n;
                    int left = j > 0 ? dp[i][j - 1] : 2 * n;

                    dp[i][j] = Math.min(top, left) + 1;
                }
            }
        }

        if (sum == n * n || sum == 0) {
            return -1;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] != 1) {
                    int bottom = i < n - 1 ? dp[i + 1][j] : 2 * n;
                    int right = j < n - 1 ? dp[i][j + 1] : 2 * n;

                    dp[i][j] = Math.min(Math.min(bottom, right) + 1, dp[i][j]);
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }

        return answer;
    }
}
