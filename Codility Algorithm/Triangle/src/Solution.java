//
// sorting(Triangle)
// https://app.codility.com/programmers/lessons/6-sorting/triangle/
// Created by hyungwook on 2021/10/27.
//

import java.util.Arrays;

public class Solution {

    public int solution(int[] A) {
        int answer = 0;
        int length = A.length;

        Arrays.sort(A);

        for (int i = 2; i < length; i++) {
            if ((long) A[i - 2] + (long) A[i - 1] > A[i]) {
                answer = 1;
                break;
            }
        }

        return answer;
    }
}
