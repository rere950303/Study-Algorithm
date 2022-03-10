//
// Soring, Array(Reduction Operations to Make the Array Elements Equal)
// https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/
// Created by hyungwook on 2022/03/09.
//

import java.util.Arrays;

public class Solution {

    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int answer = 0;
        int num = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                num++;
            }
            answer += num;
        }

        return answer;
    }
}