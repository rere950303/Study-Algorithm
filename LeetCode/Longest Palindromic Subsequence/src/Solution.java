//
// DP, String(Longest Palindromic Subsequence)
// https://leetcode.com/problems/longest-palindromic-subsequence/
// Created by hyungwook on 2022/05/06.
//

public class Solution {

    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = i; j >= 0; j--) {
                if (i == j) {
                    dp[i][j] = 1;
                } else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i - 1][j + 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i - 1][j]);
                }
            }
        }

        return dp[length - 1][0];
    }
}