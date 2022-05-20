//
// DP, Math(Predict the Winner)
// https://leetcode.com/problems/predict-the-winner/
// Created by hyungwook on 2022/05/20.
//

public class Solution {

    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= nums.length - i; j++) {
                if (i == 1) {
                    dp[j][j] = nums[j];
                } else {
                    dp[j][j + i - 1] = Math.max(nums[j + i - 1] - dp[j][j + i - 2], nums[j] - dp[j + 1][j + i - 1]);
                }
            }
        }

        return dp[0][nums.length - 1] >= 0;
    }
}