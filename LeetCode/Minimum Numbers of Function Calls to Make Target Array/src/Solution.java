//
// Greedy, Array(Minimum Numbers of Function Calls to Make Target Array)
// https://leetcode.com/problems/minimum-numbers-of-function-calls-to-make-target-array/
// Created by hyungwook on 2022/03/09.
//

public class Solution {

    public int minOperations(int[] nums) {
        int answer = 0;
        boolean allZeros = false;

        while (!allZeros) {
            allZeros = true;

            for (int i = 0; i < nums.length; i++) {
                answer += nums[i] % 2;
                nums[i] /= 2;
                if (nums[i] != 0)
                    allZeros = false;
            }

            answer++;
        }

        return answer - 1;
    }
}