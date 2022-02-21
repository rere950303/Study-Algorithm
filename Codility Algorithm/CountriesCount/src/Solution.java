//
// Data Structures(CountriesCount)
// https://app.codility.com/programmers/trainings/7/countries_count/
// Created by hyungwook on 2022/02/20.
//

import java.util.Stack;

public class Solution {

    int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int[][] A;
    int r;
    int c;

    public int solution(int[][] A) {
        this.A = A;
        r = A.length;
        c = A[0].length;
        int answer = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (A[i][j] != Integer.MAX_VALUE) {
                    int color = A[i][j];
                    answer++;
                    A[i][j] = Integer.MAX_VALUE;
                    dfs(color, i, j);
                }
            }
        }

        return answer;
    }

    private void dfs(int color, int r, int c) {
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{r, c, 0});

        while (!stack.isEmpty()) {
            int[] pop = stack.pop();

            for (int i = pop[2]; i < 4; i++) {
                int rn = pop[0] + dir[i][0];
                int cn = pop[1] + dir[i][1];

                if (rn >= 0 && rn < this.r && cn >= 0 && cn < this.c && A[rn][cn] == color && A[rn][cn] != Integer.MAX_VALUE) {
                    A[rn][cn] = Integer.MAX_VALUE;
                    pop[2] = i + 1;
                    stack.add(pop);
                    stack.add(new int[]{rn, cn, 0});
                    break;
                }
            }
        }
    }
}