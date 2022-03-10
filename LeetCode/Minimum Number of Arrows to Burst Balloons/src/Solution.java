//
// Greedy, Soring, Array(Minimum Number of Arrows to Burst Balloons)
// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
// Created by hyungwook on 2022/03/10.
//

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        int end = points[0][1];
        int answer = 1;

        for (int[] point : points) {
            if (point[0] > end) {
                end = point[1];
                answer++;
            }
        }

        return answer;
    }
}