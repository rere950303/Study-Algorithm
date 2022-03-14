//
// Prefix Sum, Array(Product of Array Except Self)
// https://leetcode.com/problems/product-of-array-except-self/
// Created by hyungwook on 2022/03/12.
//

public class Solution {

    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        answer[nums.length - 1] = nums[nums.length - 1];

        for (int i = answer.length - 2; i >= 0; i--) {
            answer[i] = answer[i + 1] * nums[i];
        }

        for (int i = 1; i < nums.length; i++) {
            nums[i] *= nums[i - 1];
        }

        for (int i = 0; i < answer.length; i++) {
            if (i == 0) {
                answer[i] = answer[i + 1];
            } else if (i == answer.length - 1) {
                answer[i] = nums[i - 1];
            } else {
                answer[i] = answer[i + 1] * nums[i - 1];
            }
        }

        return answer;
    }
}