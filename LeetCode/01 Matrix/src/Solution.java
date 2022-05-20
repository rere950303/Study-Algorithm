//
// BFS, Matrix(01 Matrix)
// https://leetcode.com/problems/01-matrix/
// Created by hyungwook on 2022/05/12.
//

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] isVisit = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    isVisit[i][j] = true;
                }
            }
        }
        int l = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int r = poll[0];
                int c = poll[1];

                if (mat[r][c] == 1) {
                    mat[r][c] = l;
                }

                for (int j = 0; j < 4; j++) {
                    int rn = r + dir[j][0];
                    int cn = c + dir[j][1];

                    if (rn >= 0 && rn < m && cn >= 0 && cn < n && !isVisit[rn][cn]) {
                        isVisit[rn][cn] = true;
                        queue.add(new int[]{rn, cn});
                    }
                }
            }

            l++;
        }

        return mat;
    }
}