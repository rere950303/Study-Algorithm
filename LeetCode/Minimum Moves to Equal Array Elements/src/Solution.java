//
// Array, Math(Minimum Moves to Equal Array Elements)
// https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
// Created by hyungwook on 2022/03/06.
//

public class Solution {

    public int minMoves(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(min, nums[i]);
        }

        return sum - nums.length * min;
    }
}