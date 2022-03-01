//
// Array, Math, Greedy, Sorting(Smallest Range II)
// https://leetcode.com/problems/smallest-range-ii/submissions/
// Created by hyungwook on 2022/03/01.
//

import java.util.Arrays;

public class Solution {

    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int answer = nums[nums.length - 1] - nums[0];

        for (int i = 0; i < nums.length - 1; i++) {
            int high = Math.max(nums[nums.length - 1] - k, nums[i] + k);
            int low = Math.min(nums[i + 1] - k, nums[0] + k);

            answer = Math.min(answer, high - low);
        }

        return answer;
    }
}