//
// Array, Sorting, Greedy(Merge Intervals)
// https://leetcode.com/problems/merge-intervals/
// Created by hyungwook on 2022/02/27.
//

import java.util.Arrays;

public class Solution {

    public int[][] merge(int[][] intervals) {
        int[][] answer = new int[intervals.length][2];
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        int idx = 0;
        answer[0][0] = intervals[0][0];
        answer[0][1] = intervals[0][1];

        for (int[] interval : intervals) {
            if (interval[0] <= answer[idx][1]) {
                answer[idx][1] = Math.max(answer[idx][1], interval[1]);
            } else {
                idx++;
                answer[idx][0] = interval[0];
                answer[idx][1] = interval[1];
            }
        }

        return Arrays.copyOfRange(answer, 0, idx + 1);
    }
}