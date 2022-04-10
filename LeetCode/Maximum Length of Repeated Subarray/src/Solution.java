//
// DP, Sliding Window, Array(Maximum Length of Repeated Subarray)
// https://leetcode.com/problems/maximum-length-of-repeated-subarray/
// Created by hyungwook on 2022/04/06.
//

public class Solution {

    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int answer = 0;

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    answer = Math.max(answer, dp[i + 1][j + 1]);
                }
            }
        }

        return answer;
    }
}