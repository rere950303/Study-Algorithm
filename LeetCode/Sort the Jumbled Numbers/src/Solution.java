//
// Sorting, Array(Sort the Jumbled Numbers)
// https://leetcode.com/problems/sort-the-jumbled-numbers/
// Created by hyungwook on 2022/04/08.
//

import java.util.stream.IntStream;

public class Solution {

    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[][] pair = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            pair[i][0] = getConvertedNum(nums[i], mapping);
            pair[i][1] = nums[i];
        }
        mergeSort(pair, 0, nums.length - 1);

        return IntStream.range(0, nums.length).map(i -> pair[i][1]).toArray();
    }

    private int getConvertedNum(int num, int[] mapping) {
        if (num < 10) {
            return mapping[num];
        }
        int tmp = 0;
        int digit = 1;

        while (num > 0) {
            int i = num % 10;
            tmp += mapping[i] * digit;
            digit *= 10;
            num /= 10;
        }

        return tmp;
    }

    private void mergeSort(int[][] pair, int pl, int pr) {
        if (pl < pr) {
            int mid = (pl + pr) / 2;
            int p = 0;
            int i;
            int j = 0;
            int k = pl;
            mergeSort(pair, pl, mid);
            mergeSort(pair, mid + 1, pr);
            int[][] buff = new int[pr - pl][2];
            for (i = pl; i <= mid; i++) {
                buff[p++] = pair[i];
            }
            while (i <= pr && j < p) {
                pair[k++] = (buff[j][0] <= pair[i][0]) ? buff[j++] : pair[i++];
            }
            while (j < p) {
                pair[k++] = buff[j++];
            }
        }
    }
}