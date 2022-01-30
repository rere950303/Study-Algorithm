//
// Caterpillar method(MinAbsSumOfTwo)
// https://app.codility.com/programmers/lessons/15-caterpillar_method/min_abs_sum_of_two/
// Created by hyungwook on 2022/01/29.
//

import java.util.Arrays;

public class Solution {

    public int solution(int[] A) {
        int length = A.length;
        int pl = 0;
        int pr = length - 1;
        int answer = Integer.MAX_VALUE;

        Arrays.sort(A);

        while (pl <= pr) {
            answer = Math.min(answer, Math.abs(A[pl] + A[pr]));

            if (Math.abs(A[pl]) <= Math.abs(A[pr])) {
                pr--;
            } else {
                pl++;
            }
        }

        return answer;
    }
}
