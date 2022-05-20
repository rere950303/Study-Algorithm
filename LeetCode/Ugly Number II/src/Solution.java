//
// DP, Math(Ugly Number II)
// https://leetcode.com/problems/ugly-number-ii/
// Created by hyungwook on 2022/05/11.
//

public class Solution {

    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int twoCount = 0;
        int threeCount = 0;
        int fiveCount = 0;

        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(dp[twoCount] * 2, dp[threeCount] * 3), dp[fiveCount] * 5);
            dp[i] = min;

            if (min % 2 == 0) {
                twoCount++;
            }
            if (min % 3 == 0) {
                threeCount++;
            }
            if (min % 5 == 0) {
                fiveCount++;
            }
        }

        return dp[n - 1];
    }
}