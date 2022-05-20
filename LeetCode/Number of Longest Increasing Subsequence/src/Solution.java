//
// DP, Array(Number of Longest Increasing Subsequence)
// https://leetcode.com/problems/number-of-longest-increasing-subsequence/
// Created by hyungwook on 2022/05/18.
//

import java.util.Arrays;

public class Solution {

    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        int max = 0;

        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    } else if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                }
            }

            max = Math.max(max, dp[i]);
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == max) {
                ans += count[i];
            }
        }

        return ans;
    }
}