//
// Binary Search, Sliding Window, Prefix Sum(Minimum Size Subarray Sum)
// https://leetcode.com/problems/minimum-size-subarray-sum/
// Created by hyungwook on 2022/05/01.
//

import java.util.Arrays;

public class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int answer = 0;
        int pl = 1;
        int pr = nums.length;

        while (pl <= pr) {
            int mid = (pl + pr) / 2;

            if (isAnswer(target, nums, mid)) {
                answer = mid;
                pr = mid - 1;
            } else {
                pl = mid + 1;
            }
        }

        return answer;
    }

    private boolean isAnswer(int target, int[] nums, int len) {
        int sum = Arrays.stream(nums, 0, len).sum();
        int i = len;

        while (i < nums.length) {
            if (sum >= target) {
                return true;
            }
            sum += nums[i] - nums[i - len];
            i++;
        }

        return sum >= target ? true : false;
    }
}
