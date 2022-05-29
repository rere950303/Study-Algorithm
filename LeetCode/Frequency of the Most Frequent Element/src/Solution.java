//
// Binary Search, Prefix Sum, Sorting, Greedy, Array(Frequency of the Most Frequent Element)
// https://leetcode.com/problems/frequency-of-the-most-frequent-element/
// Created by hyungwook on 2022/05/27.
//

import java.util.Arrays;

public class Solution {

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int pl = 1;
        int pr = nums.length;
        int answer = 0;
        int[] prefixSum = new int[nums.length + 1];

        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        while (pl <= pr) {
            int mid = (pl + pr) / 2;

            if (can(mid, nums, prefixSum, k)) {
                answer = mid;
                pl = mid + 1;
            } else {
                pr = mid - 1;
            }
        }

        return answer;
    }

    private boolean can(int len, int[] nums, int[] prefixSum, int k) {
        for (int i = len; i < prefixSum.length; i++) {
            if (nums[i - 1] * len - (prefixSum[i] - prefixSum[i - len]) <= k) {
                return true;
            }
        }

        return false;
    }
}