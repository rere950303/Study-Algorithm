//
// Greedy(Increasing Triplet Subsequence)
// https://leetcode.com/problems/increasing-triplet-subsequence/
// Created by hyungwook on 2022/05/12.
//

public class Solution {

    public boolean increasingTriplet(int[] nums) {
        int[] dp = new int[3];
        int len = 0;

        for (int num : nums) {
            int i = len;

            for (; i > 0; i--) {
                if (num > dp[i - 1]) {
                    break;
                }
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
            if (len == 3) {
                return true;
            }
        }

        return false;
    }
}