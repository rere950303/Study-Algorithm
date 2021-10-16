//
// Time Complexity(TapeEquilibrium)
// https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
// Created by hyungwook on 2021/09/27.
//

import java.util.Optional;

public class Solution {

    public int solution(int[] A) {
        int length = A.length;
        int totalSum = 0;
        for (int i : A) {
            totalSum += i;
        }
        int min = Integer.MAX_VALUE;
        int ltSum = 0;

        for (int i = 0; i < length - 1; i++) {
            ltSum += A[i];
            int rtSum = totalSum - ltSum;
            min = Math.min(min, Math.abs(ltSum - rtSum));
        }

        Optional.of("123").filter()
        return min;
    }
}
