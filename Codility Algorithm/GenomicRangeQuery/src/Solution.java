//
// Prefix Sums(GenomicRangeQuery)
// https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
// Created by hyungwook on 2021/10/24.
//

public class Solution {

    public int[] solution(String S, int[] P, int[] Q) {
        int length = P.length;
        int[][] p = new int[5][S.length()];
        int[] answer = new int[length];

        p[getFactor(S.charAt(0))][0]++;

        for (int i = 1; i < S.length(); i++) {
            p[1][i] = p[1][i - 1];
            p[2][i] = p[2][i - 1];
            p[3][i] = p[3][i - 1];
            p[4][i] = p[4][i - 1];

            p[getFactor(S.charAt(i))][i]++;
        }

        for (int i = 0; i < length; i++) {
            if (P[i] == 0) {
                for (int j = 1; j <= 4; j++) {
                    if (p[j][Q[i]] != 0) {
                        answer[i] = j;
                        break;
                    }
                }
            } else {
                for (int j = 1; j <= 4; j++) {
                    if (p[j][Q[i]] != p[j][P[i] - 1]) {
                        answer[i] = j;
                        break;
                    }
                }
            }
        }

        return answer;
    }

    private int getFactor(char c) {
        if (c == 'A') {
            return 1;
        } else if (c == 'C') {
            return 2;
        } else if (c == 'G') {
            return 3;
        } else {
            return 4;
        }
    }
}