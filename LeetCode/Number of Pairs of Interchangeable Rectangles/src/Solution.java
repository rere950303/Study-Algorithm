//
// Hash Table, Math(Number of Pairs of Interchangeable Rectangles)
// https://leetcode.com/problems/number-of-pairs-of-interchangeable-rectangles/
// Created by hyungwook on 2022/03/31.
//

import java.util.HashMap;

public class Solution {

    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double, Long> ratioMap = new HashMap<>();

        for (int[] rectangle : rectangles) {
            double ratio = (double) rectangle[0] / rectangle[1];
            ratioMap.put(ratio, ratioMap.getOrDefault(ratio, 0L) + 1);
        }
        long answer = 0;

        for (Long value : ratioMap.values()) {
            answer += value * (value - 1) / 2;
        }

        return answer;
    }
}
