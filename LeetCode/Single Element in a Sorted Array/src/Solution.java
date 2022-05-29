//
// Binary Search, Array(Single Element in a Sorted Array)
// https://leetcode.com/problems/single-element-in-a-sorted-array/
// Created by hyungwook on 2022/05/22.
//

public class Solution {

    public int singleNonDuplicate(int[] nums) {
        int pl = 0;
        int pr = nums.length - 1;

        while (pl < pr) {
            int mid = (pl + pr) / 2;

            if (mid % 2 == 1) {
                mid--;
            }

            if (nums[mid] != nums[mid + 1]) {
                pr = mid;
            } else {
                pl = mid + 2;
            }
        }

        return nums[pl];
    }
}