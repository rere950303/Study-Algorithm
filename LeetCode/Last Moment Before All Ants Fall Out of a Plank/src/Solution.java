//
// Brainteaser, Simulation, Array(Last Moment Before All Ants Fall Out of a Plank)
// https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/
// Created by hyungwook on 2022/03/11.
//

public class Solution {

    public int getLastMoment(int n, int[] left, int[] right) {
        int leftMax = 0;

        for (int i = 0; i < right.length; i++) {
            leftMax = Math.max(leftMax, n - right[i]);
        }
        int rightMax = 0;

        for (int i = 0; i < left.length; i++) {
            rightMax = Math.max(rightMax, left[i]);
        }

        return Math.max(leftMax, rightMax);
    }
}