//
// Greedy, Sorting, Array(Minimum Increment to Make Array Unique)
// https://leetcode.com/problems/minimum-increment-to-make-array-unique/
// Created by hyungwook on 2022/03/16.
//

import java.util.Arrays;

public class Solution {

    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int answer = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                answer += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }

        return answer;
    }
}
