//
// Two Pointers, Greedy, Array(Shortest Unsorted Continuous Subarray)
// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
// Created by hyungwook on 2022/03/31.
//

public class Solution {

    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        int pl = 1;
        int pr = 0;
        int max = nums[0];
        int min = nums[length - 1];

        for (int i = 0; i < length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[length - i - 1]);

            if (max != nums[i]) {
                pr = i;
            }
            if (min != nums[length - i - 1]) {
                pl = length - i - 1;
            }
        }

        return pr - pl + 1;
    }
}