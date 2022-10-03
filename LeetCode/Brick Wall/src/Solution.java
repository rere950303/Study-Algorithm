//
// Hash Table, Array(Brick Wall)
// https://leetcode.com/problems/brick-wall/
// Created by hyungwook on 2022/07/01.
//

import java.util.HashMap;
import java.util.List;

public class Solution {

    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> edges = new HashMap<>();
        int max = 0;

        for (List<Integer> bricks : wall) {
            int tmp = 0;

            for (int i = 0; i < bricks.size() - 1; i++) {
                tmp += bricks.get(i);
                edges.put(tmp, edges.getOrDefault(tmp, 0) + 1);

                max = Math.max(max, edges.get(tmp));
            }
        }

        return wall.size() - max;
    }
}