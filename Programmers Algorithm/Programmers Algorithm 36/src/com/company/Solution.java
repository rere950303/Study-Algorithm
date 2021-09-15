//
//  Programmers Algorithm 36(순위)
//  https://programmers.co.kr/learn/courses/30/lessons/49191
//  Created by hyungwook on 2021/08/06.
//
package com.company;

public class Solution {

    public int solution(int n, int[][] results) {
        int[][] history = new int[n + 2][n + 2];
        int answer = 0;

        for (int[] result : results) {
            history[result[0]][result[1]] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (history[j][i] == 1) {
                    for (int k = 1; k <= n; k++) {
                        if (history[i][k] == 1) {
                            history[j][k] = 1;
                        }
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int result = 0;
            for (int j = 1; j <= n; j++) {
                if (history[i][j] == 1 || history[j][i] == 1) {
                    result++;
                }
            }
            if (result == n - 1) {
                answer++;
            }
        }

        return answer;
    }
}
