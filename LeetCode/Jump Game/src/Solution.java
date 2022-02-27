//
// Array, DP, Greedy(Jump Game)
// https://leetcode.com/problems/jump-game/
// Created by hyungwook on 2022/02/27.
//

public class Solution {

    public boolean canJump(int[] nums) {
        int start = 0;
        int end = 1;
        int maxPos = 0;

        while (end < nums.length) {
            for (int i = start; i < end; i++) {
                maxPos = Math.max(maxPos, i + nums[i]);
            }
            if (maxPos + 1 == end) {
                return false;
            }
            start = end;
            end = maxPos + 1;
        }

        return true;
    }
}