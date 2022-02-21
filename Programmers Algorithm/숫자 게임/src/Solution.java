//
// 그리디(숫자 게임)
// https://programmers.co.kr/learn/courses/30/lessons/12987
// Created by hyungwook on 2022/02/14.
//

import java.util.Arrays;

public class Solution {

    public int solution(int[] A, int[] B) {
        int answer = 0;
        int length = A.length;

        Arrays.sort(A);
        Arrays.sort(B);

        int aIdx = 0;
        int bIdx = 0;

        while (bIdx < length && aIdx < length) {
            if (A[aIdx] < B[bIdx]) {
                answer++;
                aIdx++;
                bIdx++;
            } else {
                bIdx++;
            }
        }

        return answer;
    }
}