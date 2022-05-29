//
// Sliding Window, Array(Binary Subarrays With Sum)
// https://leetcode.com/problems/binary-subarrays-with-sum/
// Created by hyungwook on 2022/05/27.
//

public class Solution {

    public int numSubarraysWithSum(int[] nums, int goal) {
        int answer = 0;
        int pl = 0;
        int pr = 0;
        int lSum = 0;
        int rSum = 0;

        for (int i = 0; i < nums.length; i++) {
            lSum += nums[i];
            while (lSum > goal) {
                lSum -= nums[pl++];
            }
            rSum += nums[i];
            while (pr < i && (rSum > goal || rSum == goal && nums[pr] == 0)) {
                rSum -= nums[pr++];
            }

            if (lSum == goal) {
                answer += pr - pl + 1;
            }
        }

        return answer;
    }
}