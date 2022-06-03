//
// DP, Matrix(Knight Probability in Chessboard)
// https://leetcode.com/problems/knight-probability-in-chessboard/
// Created by hyungwook on 2022/05/30.
//

public class Solution {

    public double knightProbability(int n, int k, int row, int column) {
        int[][] dir = new int[][]{{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
        double[][] matrix = new double[n][n];
        matrix[row][column] = 1;

        while (k > 0) {
            double[][] matrixTmp = new double[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] != 0) {
                        for (int p = 0; p < 8; p++) {
                            int rn = i + dir[p][0];
                            int cn = j + dir[p][1];

                            if (rn >= 0 && rn < n && cn >= 0 && cn < n) {
                                matrixTmp[rn][cn] += matrix[i][j] / 8;
                            }
                        }
                    }
                }
            }

            matrix = matrixTmp;
            k--;
        }

        double sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += matrix[i][j];
            }
        }

        return sum;
    }
}