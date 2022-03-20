//
// DP, Array(Last Stone Weight II)
// https://leetcode.com/problems/last-stone-weight-ii/
// Created by hyungwook on 2022/03/18.
//

public class Solution {

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;

        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }

        int half = sum / 2;
        int[] dp = new int[half + 1];

        for (int i = 0; i < stones.length; i++) {
            for (int j = half; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }

        return sum - 2 * dp[half];
    }
}