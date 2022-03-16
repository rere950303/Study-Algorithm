//
// DP, Math(Count Sorted Vowel Strings)
// https://leetcode.com/problems/count-sorted-vowel-strings/
// Created by hyungwook on 2022/03/16.
//

public class Solution {

    public int countVowelStrings(int n) {
        int[][] dp = new int[n + 1][6];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 5; j++) {
                dp[i][j] = (i == 1 ? 1 : dp[i - 1][j]) + dp[i][j - 1];
            }
        }

        return dp[n][5];
    }
}