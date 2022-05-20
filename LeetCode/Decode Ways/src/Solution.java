//
// DP(Decode Ways)
// https://leetcode.com/problems/decode-ways/
// Created by hyungwook on 2022/05/11.
//

public class Solution {

    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i <= s.length(); i++) {
            Integer encoded = Integer.valueOf(s.substring(i - 2, i));

            if (s.charAt(i - 2) != '0' && encoded >= 1 && encoded <= 26) {
                dp[i] += dp[i - 2];
            }
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
        }

        return dp[s.length()];
    }
}