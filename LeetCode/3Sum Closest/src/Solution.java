//
// Array, Two Pointers, Sorting(3Sum Closest)
// https://leetcode.com/problems/3sum-closest/
// Created by hyungwook on 2022/02/24.
//

import java.util.Arrays;

public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        int answer = Integer.MAX_VALUE;
        int interval = Integer.MAX_VALUE;

        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int pl = i + 1;
            int pr = length - 1;

            while (pl < pr) {
                if (pr < length - 1 && nums[pr] == nums[pr + 1]) {
                    pr--;
                    continue;
                }

                int sum = nums[i] + nums[pl] + nums[pr];
                if (sum - target == 0) {
                    return sum;
                }
                if (Math.abs(sum - target) < interval) {
                    answer = sum;
                    interval = Math.abs(sum - target);
                }

                if (sum < target) {
                    pl++;
                } else {
                    pr--;
                }
            }
        }

        return answer;
    }
}