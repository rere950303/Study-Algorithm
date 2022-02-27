//
// Array, Binary Search(Search in Rotated Sorted Array)
// https://leetcode.com/problems/search-in-rotated-sorted-array/
// Created by hyungwook on 2022/02/25.
//

import java.util.Arrays;

public class Solution {

    public int search(int[] nums, int target) {
        int i = 0;
        for (; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                break;
            }
        }

        i++;
        int answer = 0;

        answer = Arrays.binarySearch(nums, 0, i, target);

        if (answer < 0) {
            answer = Arrays.binarySearch(nums, i, nums.length, target);
        }

        return answer < 0 ? -1 : answer;
    }
}