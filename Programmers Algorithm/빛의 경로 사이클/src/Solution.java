//
// 규칙 찾기(빛의 경로 사이클)
// https://programmers.co.kr/learn/courses/30/lessons/86052?language=java
// Created by hyungwook on 2022/02/03.
//

import java.util.ArrayList;

public class Solution {

    int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    ArrayList<Integer> answer = new ArrayList<>();
    boolean[][][] check;
    int r;
    int c;

    public int[] solution(String[] grid) {
        this.r = grid.length;
        this.c = grid[0].length();
        this.check = new boolean[r][c][4];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < 4; k++) {
                    if (!check[i][j][k]) {
                        answer.add(light(grid, i, j, k));
                    }
                }
            }
        }

        return answer.stream().sorted().mapToInt(i -> i.intValue()).toArray();
    }

    private Integer light(String[] grid, int r, int c, int d) {
        int count = 0;

        while (true) {
            if (check[r][c][d]) {
                break;
            }

            count++;
            check[r][c][d] = true;
            char alphabet = grid[r].charAt(c);

            if (alphabet == 'L') {
                d = (d + 3) % 4;
            } else if (alphabet == 'R') {
                d = (d + 1) % 4;
            }

            r = (r + dir[d][0] + this.r) % this.r;
            c = (c + dir[d][1] + this.c) % this.c;
        }

        return count;
    }
}