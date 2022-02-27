//
// Hash Table, Math, String(Integer to Roman)
// https://leetcode.com/problems/integer-to-roman/
// Created by hyungwook on 2022/02/24.
//

public class Solution {

    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int start = 0;
        String answer = "";

        while (num > 0) {
            start = getStart(num, nums, start);
            answer += romans[start];
            num -= nums[start];
        }

        return answer;
    }

    private int getStart(int num, int[] nums, int start) {
        for (int i = start; i < 13; i++) {
            if (nums[i] <= num) {
                start = i;
                break;
            }
        }
        return start;
    }
}