//
// Heap, Sorting, Array, Math(K Closest Points to Origin)
// https://leetcode.com/problems/k-closest-points-to-origin/
// Created by hyungwook on 2022/05/07.
//

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((i1, i2) -> Integer.compare(i1[2], i2[2]));

        for (int[] point : points) {
            queue.add(new int[]{point[0], point[1], point[0] * point[0] + point[1] * point[1]});
        }
        List<int[]> answer = new ArrayList<>();

        while (k > 0) {
            int[] poll = queue.poll();

            answer.add(new int[]{poll[0], poll[1]});
            k--;
        }

        return answer.stream().toArray(int[][]::new);
    }
}