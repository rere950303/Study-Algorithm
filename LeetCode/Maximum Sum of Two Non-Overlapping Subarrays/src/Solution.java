//
// Sliding Window, DP, Array(Maximum Sum of Two Non-Overlapping Subarrays)
// https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/
// Created by hyungwook on 2022/05/26.
//

public class Solution {

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int[] prefixSum = new int[nums.length + 1];

        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        int firstMax = 0;
        int secondMax = 0;
        int answer = 0;

        for (int i = firstLen + secondLen; i <= nums.length; i++) {
            firstMax = Math.max(firstMax, prefixSum[i - firstLen] - prefixSum[i - firstLen - secondLen]);
            secondMax = Math.max(secondMax, prefixSum[i - secondLen] - prefixSum[i - secondLen - firstLen]);

            answer = Math.max(answer, Math.max(prefixSum[i] - prefixSum[i - firstLen] + firstMax, prefixSum[i] - prefixSum[i - secondLen] + secondMax));
        }

        return answer;
    }
}
