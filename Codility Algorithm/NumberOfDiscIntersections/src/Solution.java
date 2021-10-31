//
// Sorting(NumberOfDiscIntersections)
// https://app.codility.com/programmers/lessons/6-sorting/number_of_disc_intersections/
// Created by hyungwook on 2021/10/29.
//

import java.util.Arrays;

public class Solution {

    public int solution(int[] A) {
        int answer = 0;
        int length = A.length;
        long[] lt = new long[length];
        long[] rt = new long[length];

        for (int i = 0; i < length; i++) {
            lt[i] = i - (long) A[i];
            rt[i] = i + (long) A[i];
        }

        Arrays.sort(lt);
        Arrays.sort(rt);

        int pc = 0;

        for (int i = 0; i < length; i++) {
            while (pc < length && rt[i] >= lt[pc]) {
                pc++;
            }

            answer += pc - 1 - i;
        }

        if (answer > 10000000) {
            answer = -1;
        }

        return answer;
    }
}