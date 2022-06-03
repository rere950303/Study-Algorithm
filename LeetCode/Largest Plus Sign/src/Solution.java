//
// DP, Matrix(Largest Plus Sign)
// https://leetcode.com/problems/largest-plus-sign/
// Created by hyungwook on 2022/05/31.
//

import java.util.Arrays;

class Solution {

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 1);
        }
        for (int[] mine : mines) {
            dp[mine[0]][mine[1]] = 0;
        }
        int count;

        for (int r = 0; r < n; r++) {
            count = 0;
            for (int c = 0; c < n; c++) {
                count = dp[r][c] == 0 ? 0 : count + 1;
                dp[r][c] = count;
            }
            count = 0;
            for (int c = n - 1; c >= 0; c--) {
                count = dp[r][c] == 0 ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }
        }
        int answer = 0;

        for (int c = 0; c < n; c++) {
            count = 0;
            for (int r = 0; r < n; r++) {
                count = dp[r][c] == 0 ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }
            count = 0;
            for (int r = n - 1; r >= 0; r--) {
                count = dp[r][c] == 0 ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
                answer = Math.max(answer, dp[r][c]);
            }
        }

        return answer;
    }
}