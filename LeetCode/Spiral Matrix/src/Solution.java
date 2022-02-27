//
// Array, Matrix, Simulation(Spiral Matrix)
// https://leetcode.com/problems/spiral-matrix/
// Created by hyungwook on 2022/02/24.
//

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> answer = new ArrayList<>();
        int num = m * n;
        int r = 0;
        int c = 0;

        while (num > 0) {
            while (c < n && matrix[r][c] != Integer.MAX_VALUE) {
                answer.add(matrix[r][c]);
                matrix[r][c] = Integer.MAX_VALUE;
                c++;
                num--;
            }
            c--;
            r++;
            while (r < m && matrix[r][c] != Integer.MAX_VALUE) {
                answer.add(matrix[r][c]);
                matrix[r][c] = Integer.MAX_VALUE;
                r++;
                num--;
            }
            r--;
            c--;
            while (c >= 0 && matrix[r][c] != Integer.MAX_VALUE) {
                answer.add(matrix[r][c]);
                matrix[r][c] = Integer.MAX_VALUE;
                c--;
                num--;
            }
            c++;
            r--;
            while (r >= 0 && matrix[r][c] != Integer.MAX_VALUE) {
                answer.add(matrix[r][c]);
                matrix[r][c] = Integer.MAX_VALUE;
                r--;
                num--;
            }
            r++;
            c++;
        }

        return answer;
    }
}