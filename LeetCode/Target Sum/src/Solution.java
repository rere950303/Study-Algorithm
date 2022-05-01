//
// DP(Target Sum)
// https://leetcode.com/problems/target-sum/
// Created by hyungwook on 2022/04/13.
//

public class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }
        if ((target + sum) % 2 == 1 || target > sum) {
            return 0;
        }
        int targetSum = (sum + target) / 2;
        targetSum = targetSum < 0 ? -targetSum : targetSum;
        int[] dp = new int[targetSum + 1];
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = targetSum; j >= nums[i]; j--) {
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }

        return dp[targetSum];
    }
}