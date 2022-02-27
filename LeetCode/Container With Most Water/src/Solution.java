//
// Array, Two Pointers, Greedy(Container With Most Water)
// https://leetcode.com/problems/container-with-most-water/
// Created by hyungwook on 2022/02/24.
//

public class Solution {

    public int maxArea(int[] height) {
        int answer = Integer.MIN_VALUE;
        int pl = 0;
        int pr = height.length - 1;

        while (pl < pr) {
            answer = Math.max(answer, (pr - pl) * Math.min(height[pl], height[pr]));

            if (height[pl] == height[pr]) {
                pl++;
                pr--;
            } else if (height[pl] > height[pr]) {
                pr--;
            } else {
                pl++;
            }
        }

        return answer;
    }
}