//
// 정렬(최솟값 만들기)
// https://programmers.co.kr/learn/courses/30/lessons/12941?language=java
// Created by hyungwook on 2022/02/17.
//

import java.util.Arrays;

public class Solution {

    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        int length = A.length;

        for (int i = 0; i < length; i++) {
            answer += A[i] * B[length - i - 1];
        }

        return answer;
    }
}
