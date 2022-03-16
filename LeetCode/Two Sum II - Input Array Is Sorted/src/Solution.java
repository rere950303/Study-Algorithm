//
// Two Pointers, Array(Two Sum II - Input Array Is Sorted)
// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
// Created by hyungwook on 2022/03/16.
//

public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int pl = 0;
        int pr = numbers.length - 1;
        int sum = numbers[pl] + numbers[pr];

        while (pl < pr) {
            if (sum == target) {
                return new int[]{pl + 1, pr + 1};
            } else if (sum > target) {
                sum = sum - numbers[pr] + numbers[--pr];
            } else {
                sum = sum - numbers[pl] + numbers[++pl];
            }
        }

        return null;
    }
}