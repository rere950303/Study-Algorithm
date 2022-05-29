//
// Binary Search, Sorting, Array(Find Right Interval)
// https://leetcode.com/problems/find-right-interval/
// Created by hyungwook on 2022/05/20.
//

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public int[] findRightInterval(int[][] intervals) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
        }

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int[] answer = new int[intervals.length];

        for (int[] interval : intervals) {
            answer[map.get(interval[0])] = getIndex(interval[1], intervals, map);
        }

        return answer;
    }

    private int getIndex(int end, int[][] intervals, HashMap<Integer, Integer> map) {
        int pl = 0;
        int pr = intervals.length;

        while (pl < pr) {
            int mid = (pl + pr) / 2;

            if (intervals[mid][0] >= end) {
                pr = mid;
            } else {
                pl = mid + 1;
            }
        }

        return pr == intervals.length ? -1 : map.get(intervals[pr][0]);
    }
}