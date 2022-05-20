//
// DP, Math(Integer Break)
// https://leetcode.com/problems/integer-break/
// Created by hyungwook on 2022/05/12.
//

public class Solution {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }

        return dp[n];
    }
}