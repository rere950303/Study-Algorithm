//
// Array, Two Pointers, Binary Search(Next Permutation)
// https://leetcode.com/problems/next-permutation/
// Created by hyungwook on 2022/02/24.
//

public class Solution {

    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int i = length - 1;

        for (; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                break;
            }
        }

        if (i == 0) {
            reverse(nums, 0);
        } else {
            int j = binarySearch(nums, i, length - 1, nums[i - 1]);
            j = j < 0 ? -j : j - 1;
            swap(nums, i - 1, j);
            reverse(nums, i);
        }
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;

        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private int binarySearch(int[] nums, int start, int end, int key) {
        int idx = -1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == key) {
                idx = mid;
                end = mid - 1;
            } else if (nums[mid] > key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return idx < 0 ? -end : idx;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}