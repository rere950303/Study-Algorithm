//
// DP(땅따먹기)
// https://programmers.co.kr/learn/courses/30/lessons/12913
// Created by hyungwook on 2022/02/14.
//

public class Solution {

    int solution(int[][] land) {
        int length = land.length;

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0;

                for (int k = 0; k < 4; k++) {
                    if (k != j) {
                        max = Math.max(max, land[i - 1][k]);
                    }
                }

                land[i][j] += max;
            }
        }

        int answer = 0;

        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, land[length - 1][i]);
        }

        return answer;
    }
}