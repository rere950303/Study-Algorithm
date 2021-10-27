//
// sorting(Distinct)
// https://app.codility.com/programmers/lessons/6-sorting/distinct/
// Created by hyungwook on 2021/10/26.
//

import java.util.Arrays;

public class Solution {

    public int solution(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        int answer = 1;

        Arrays.sort(A);

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] != A[i + 1]) {
                answer++;
            }
        }

        return answer;
    }
}