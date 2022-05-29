//
// Prefix Sum, DP, Array(Maximum Sum Circular Subarray)
// https://leetcode.com/problems/maximum-sum-circular-subarray/
// Created by hyungwook on 2022/05/23.
//

public class Solution {

    public int maxSubarraySumCircular(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int totalSum = 0;

        for (int i = 0; i < len; i++) {
            totalSum += nums[i];
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(max, sum);
        }

        if (max < 0) {
            return max;
        }

        sum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            sum = Math.min(sum + nums[i], nums[i]);
            min = Math.min(min, sum);
        }

        return Math.max(max, totalSum - min);
    }
}