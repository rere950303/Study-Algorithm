//
// DP, Array(Coin Change 2)
// https://leetcode.com/problems/coin-change-2/
// Created by hyungwook on 2022/03/12.
//

import java.util.Arrays;

public class Solution {

    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i >= coin) {
                    dp[i] = dp[i] + dp[i - coin];
                }
            }
        }

        return dp[amount];
    }
}