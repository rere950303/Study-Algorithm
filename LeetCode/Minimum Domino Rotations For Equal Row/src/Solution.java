//
// Greedy, Array(Minimum Domino Rotations For Equal Row)
// https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
// Created by hyungwook on 2022/03/20.
//

public class Solution {

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int answer = Integer.MAX_VALUE;

        for (int i = 1; i <= 6; i++) {
            int t = 0;
            int b = 0;
            boolean flag = false;

            for (int j = 0; j < tops.length; j++) {
                if (tops[j] != i && bottoms[j] != i) {
                    flag = true;
                    break;
                }
                if (tops[j] != i) {
                    t++;
                }
                if (bottoms[j] != i) {
                    b++;
                }
            }
            if (!flag) {
                answer = Math.min(answer, Math.min(t, b));
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}