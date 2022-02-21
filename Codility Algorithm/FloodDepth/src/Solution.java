//
// 2015 Contest(FloodDepth)
// https://app.codility.com/programmers/trainings/1/flood_depth/
// Created by hyungwook on 2022/02/16.
//

public class Solution {

    public int solution(int[] A) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        int length = A.length;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < length - 1; i++) {
            if (A[i] >= max) {
                max = A[i];
                min = Integer.MAX_VALUE;
            } else {
                min = Math.min(min, A[i]);
                if (A[i] < A[i + 1]) {
                    answer = Math.max(answer, Math.min(A[i + 1], max) - min);
                }
            }
        }

        return answer;
    }
}