//
// Matrix, Math(Rotate Image)
// https://leetcode.com/problems/rotate-image/
// Created by hyungwook on 2022/02/25.
//

public class Solution {

    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int time = length / 2;
        int n = length;

        for (int i = 0; i < time; i++) {
            clockWise(i, i, n, length, matrix);
            n -= 2;
        }
    }

    private void clockWise(int r, int c, int n, int length, int[][] matrix) {
        for (int i = 0; i < n - 1; i++) {
            int rn = r;
            int cn = c + i;
            int tmp1 = matrix[rn][cn];

            for (int j = 0; j < 4; j++) {
                int tmp2 = matrix[cn][length - 1 - rn];

                matrix[cn][length - 1 - rn] = tmp1;
                tmp1 = tmp2;
                int tmp = rn;

                rn = cn;
                cn = length - 1 - tmp;
            }
        }
    }
}