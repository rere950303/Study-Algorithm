//
// Two Pointer, Array, Simulation(Partition Array According to Given Pivot)
// https://leetcode.com/problems/partition-array-according-to-given-pivot/
// Created by hyungwook on 2022/03/17.
//

public class Solution {

    public int[] pivotArray(int[] nums, int pivot) {
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int pivotCount = 0;
        int pl = 0;
        int pr = 0;

        for (int i = 0; i < length; i++) {
            if (nums[i] == pivot) {
                pivotCount++;
            } else if (nums[i] > pivot) {
                right[pr++] = nums[i];
            } else {
                left[pl++] = nums[i];
            }
        }

        int pc = 0;
        for (int i = 0; i < pl; i++) {
            nums[pc++] = left[i];
        }
        for (int i = 0; i < pivotCount; i++) {
            nums[pc++] = pivot;
        }
        for (int i = 0; i < pr; i++) {
            nums[pc++] = right[i];
        }

        return nums;
    }
}