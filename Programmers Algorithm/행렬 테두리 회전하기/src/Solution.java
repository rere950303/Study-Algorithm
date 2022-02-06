//
// 규칙 찾기(행렬 테두리 회전하기)
// https://programmers.co.kr/learn/courses/30/lessons/77485?language=java
// Created by hyungwook on 2022/02/02.
//

import java.util.ArrayList;

public class Solution {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows + 1][columns + 1];
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                matrix[i][j] = ((i - 1) * columns + j);
            }
        }

        for (int[] query : queries) {
            answer.add(rotate(query, matrix));
        }

        return answer.stream().mapToInt(i -> i.intValue()).toArray();
    }

    private int rotate(int[] query, int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int x1 = query[0];
        int y1 = query[1];
        int x2 = query[2];
        int y2 = query[3];

        int x = x1;
        int y = y1;
        int reg = matrix[x1][y1];
        int tmp;

        while (true) {
            if (x == x1 && y == y1 && min != Integer.MAX_VALUE) {
                break;
            }
            if (x == x1 && y < y2) {
                y += 1;
                tmp = reg;
                min = Math.min(min, reg);
                reg = matrix[x][y];
                matrix[x][y] = tmp;
            } else if (y == y2 && x < x2) {
                x += 1;
                tmp = reg;
                min = Math.min(min, reg);
                reg = matrix[x][y];
                matrix[x][y] = tmp;
            } else if (x == x2 && y > y1) {
                y -= 1;
                tmp = reg;
                min = Math.min(min, reg);
                reg = matrix[x][y];
                matrix[x][y] = tmp;
            } else {
                x -= 1;
                tmp = reg;
                min = Math.min(min, reg);
                reg = matrix[x][y];
                matrix[x][y] = tmp;
            }
        }

        return min;
    }
}