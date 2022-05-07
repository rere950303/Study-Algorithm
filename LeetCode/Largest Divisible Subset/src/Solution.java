//
// DP, Sorting, Math, Array(Largest Divisible Subset)
// https://leetcode.com/problems/largest-divisible-subset/
// Created by hyungwook on 2022/05/06.
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int count = Arrays.stream(dp).max().getAsInt();
        int num = 0;
        List<Integer> answer = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (count == dp[i] && num % nums[i] == 0) {
                num = nums[i];
                count--;
                answer.add(nums[i]);
            }
        }

        return answer;
    }
}