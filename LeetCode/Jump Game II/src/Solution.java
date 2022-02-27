//
// Array, DP, Greedy(Jump Game II)
// https://leetcode.com/problems/jump-game-ii/
// Created by hyungwook on 2022/02/24.
//

public class Solution {

    public int jump(int[] nums) {
        int answer = 0;
        int start = 0;
        int end = 1;

        while (end < nums.length) {
            int maxPos = 0;

            for (int i = start; i < end; i++) {
                maxPos = Math.max(maxPos, i + nums[i]);
            }
            start = end;
            end = maxPos + 1;
            answer++;
        }
        return answer;
    }
}