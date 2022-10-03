//
// DP, Array(Ways to Make a Fair Array)
// https://leetcode.com/problems/ways-to-make-a-fair-array/
// Created by hyungwook on 2022/09/12.
//

class Solution {

    public int waysToMakeFair(int[] nums) {
        int totalOddSum = 0;
        int totalEvenSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                totalEvenSum += nums[i];
            } else {
                totalOddSum += nums[i];
            }
        }
        int currEvenSum = 0;
        int currOddSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                if (currEvenSum + totalOddSum - currOddSum == currOddSum + totalEvenSum - nums[i] - currEvenSum) {
                    count++;
                }
                currEvenSum += nums[i];
            } else {
                if (currOddSum + totalEvenSum - currEvenSum == currEvenSum + totalOddSum - nums[i] - currOddSum) {
                    count++;
                }
                currOddSum += nums[i];
            }
        }

        return count;
    }
}