//
// Prefix Sums(MinAvgTwoSlice)
// https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/
// Created by hyungwook on 2021/10/25.
//

public class Solution {

    public int solution(int[] A) {
        float minAvg = (A[0] + A[1]) / 2f;
        int answer = 0;

        for (int i = 2; i < A.length; i++) {
            if ((A[i - 2] + A[i - 1] + A[i]) / 3f < minAvg) {
                minAvg = (A[i - 2] + A[i - 1] + A[i]) / 3f;
                answer = i - 2;
            }
            if ((A[i - 1] + A[i]) / 2f < minAvg) {
                minAvg = (A[i - 1] + A[i]) / 2f;
                answer = i - 1;
            }
        }

        return answer;
    }
}
