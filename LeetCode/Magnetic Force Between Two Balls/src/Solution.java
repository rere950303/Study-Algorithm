//
// Binary Search, Sorting, Array(Magnetic Force Between Two Balls)
// https://leetcode.com/problems/magnetic-force-between-two-balls/
// Created by hyungwook on 2022/03/13.
//

import java.util.Arrays;

public class Solution {

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int pl = 1;
        int pr = position[position.length - 1] - position[0];
        int answer = 0;

        while (pl <= pr) {
            int pc = (pl + pr) / 2;

            if (isAnswer(position, pc, m)) {
                answer = pc;
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }
        }

        return answer;
    }

    private boolean isAnswer(int[] position, int pc, int m) {
        int count = 1;
        int start = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - start >= pc) {
                count++;
                start = position[i];
            }
        }

        return count >= m;
    }
}