//
// DP(Maximum Product Subarray)
// https://leetcode.com/problems/maximum-product-subarray/
// Created by hyungwook on 2022/05/11.
//

public class Solution {

    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int answer = max;

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            if (num < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }

            max = Math.max(max * num, num);
            min = Math.min(min * num, num);

            answer = Math.max(answer, max);
        }

        return answer;
    }
}