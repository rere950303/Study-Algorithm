//
// Sorting, Array, String, Math(Minimum Time Difference)
// https://leetcode.com/problems/minimum-time-difference/
// Created by hyungwook on 2022/06/29.
//

import java.util.Collections;
import java.util.List;

public class Solution {

    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int answer = Integer.MAX_VALUE;
        int size = timePoints.size();

        for (int i = 0; i < size; i++) {
            int interval = getInterval(timePoints.get(i), timePoints.get((i + 1) % size));

            answer = Math.min(answer, interval);
        }

        return answer;
    }

    private int getInterval(String start, String end) {
        int endMin = getMin(end);
        int startMin = getMin(start);

        if (startMin > endMin) {
            endMin += 1440;
        }

        return endMin - startMin;
    }

    private int getMin(String time) {
        String[] splits = time.split(":");

        return Integer.valueOf(splits[0]) * 60 + Integer.valueOf(splits[1]);
    }
}