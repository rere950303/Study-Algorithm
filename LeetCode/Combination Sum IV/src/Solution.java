//
// DP, Array(Combination Sum IV)
// https://leetcode.com/problems/combination-sum-iv/
// Created by hyungwook on 2022/05/01.
//

public class Solution {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }
}