//
// DP, Array, String(Ones and Zeroes)
// https://leetcode.com/problems/ones-and-zeroes/
// Created by hyungwook on 2022/06/08.
//

public class Solution {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= strs.length; i++) {
            int[] counts = getCounts(strs[i - 1]);
            int zeroCount = counts[0];
            int oneCount = counts[1];

            for (int j = m; j >= zeroCount; j--) {
                for (int k = n; k >= oneCount; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeroCount][k - oneCount] + 1);
                }
            }
        }

        return dp[m][n];
    }

    private int[] getCounts(String str) {
        int zeroCount = 0;
        int oneCount = 0;

        for (char c : str.toCharArray()) {
            if (c == '0') {
                zeroCount++;
            } else {
                oneCount++;
            }
        }

        return new int[]{zeroCount, oneCount};
    }
}