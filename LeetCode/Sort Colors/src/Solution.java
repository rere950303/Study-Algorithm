//
// Two Pointers, Sorting(Sort Colors)
// https://leetcode.com/problems/sort-colors/
// Created by hyungwook on 2022/05/26.
//

public class Solution {

    public void sortColors(int[] nums) {
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;

        for (int num : nums) {
            switch (num) {
                case 0:
                    zeroCount++;
                    break;
                case 1:
                    oneCount++;
                    break;
                case 2:
                    twoCount++;
                    break;
            }
        }
        int idx = 0;

        while (zeroCount-- > 0) {
            nums[idx++] = 0;
        }
        while (oneCount-- > 0) {
            nums[idx++] = 1;
        }
        while (twoCount-- > 0) {
            nums[idx++] = 2;
        }
    }
}