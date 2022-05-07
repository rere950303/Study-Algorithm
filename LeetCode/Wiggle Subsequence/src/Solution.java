//
// DP, Greedy, Array(Wiggle Subsequence)
// https://leetcode.com/problems/wiggle-subsequence/
// Created by hyungwook on 2022/05/07.
//

public class Solution {

    public int wiggleMaxLength(int[] nums) {
        int[] sub = new int[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            sub[i - 1] = nums[i] - nums[i - 1];
        }

        int sign = -1;
        int answer1 = 0;

        for (int i = 0; i < sub.length; i++) {
            if (sub[i] * sign < 0) {
                answer1++;
                sign *= -1;
            }
        }
        sign = 1;
        int answer2 = 0;

        for (int i = 0; i < sub.length; i++) {
            if (sub[i] * sign < 0) {
                answer2++;
                sign *= -1;
            }
        }

        return Math.max(answer1, answer2) + 1;
    }
}