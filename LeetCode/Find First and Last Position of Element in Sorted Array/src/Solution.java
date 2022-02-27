//
// Array, Binary Search(Find First and Last Position of Element in Sorted Array)
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// Created by hyungwook on 2022/02/25.
//

public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int start = binarySearch(nums, target);

        if (start < 0) {
            return new int[]{-1, -1};
        }

        int last = start;

        for (; last < nums.length; last++) {
            if (nums[last] != target) {
                break;
            }
        }

        return new int[]{start, last - 1};
    }

    private int binarySearch(int[] nums, int target) {
        int pl = 0;
        int pr = nums.length - 1;
        int idx = -1;

        while (pl <= pr) {
            int mid = (pl + pr) / 2;

            if (nums[mid] == target) {
                idx = mid;
                pr = mid - 1;
            } else if (nums[mid] > target) {
                pr = mid - 1;
            } else {
                pl = mid + 1;
            }
        }

        return idx;
    }
}