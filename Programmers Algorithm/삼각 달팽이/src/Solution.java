//
// 규칙찾기(삼각 달팽이)
// https://programmers.co.kr/learn/courses/30/lessons/68645
// Created by hyungwook on 2022/02/06.
//

import java.util.ArrayList;

public class Solution {

    int r = 0;
    int c = 0;
    int tmp = 1;
    int n;

    public int[] solution(int n) {
        if (n == 1) {
            return new int[]{1};
        }

        this.n = n;
        int[][] matrix = new int[n][n];
        int num = n * (n + 1) / 2;

        while (tmp <= num) {
            vertical(matrix);
            width(matrix);
            diagonal(matrix);
        }

        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                answer.add(matrix[i][j]);
            }
        }

        return answer.stream().mapToInt(i -> i.intValue()).toArray();
    }

    private void vertical(int[][] matrix) {
        while (r < n && matrix[r][c] == 0) {
            matrix[r++][c] = tmp++;
        }
        r--;
        c++;
    }

    private void width(int[][] matrix) {
        while (c < n && matrix[r][c] == 0) {
            matrix[r][c++] = tmp++;
        }
        r--;
        c -= 2;
    }

    private void diagonal(int[][] matrix) {
        while (matrix[r][c] == 0) {
            matrix[r--][c--] = tmp++;
        }

        r += 2;
        c++;
    }
}