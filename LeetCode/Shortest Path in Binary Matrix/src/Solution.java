//
// BFS, Matrix(Shortest Path in Binary Matrix)
// https://leetcode.com/problems/shortest-path-in-binary-matrix/
// Created by hyungwook on 2022/04/08.
//

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0) {
            return -1;
        }
        int[][] dir = new int[][]{{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        int length = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        grid[0][0] = -1;
        int l = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int r = poll[0];
                int c = poll[1];

                if (r == length - 1 && c == length - 1) {
                    return l;
                }

                for (int j = 0; j < 8; j++) {
                    int rn = r + dir[j][0];
                    int cn = c + dir[j][1];

                    if (rn >= 0 && rn < length && cn >= 0 && cn < length && grid[rn][cn] == 0) {
                        grid[rn][cn] = -1;
                        queue.add(new int[]{rn, cn});
                    }
                }
            }
            l++;
        }

        return -1;
    }
}