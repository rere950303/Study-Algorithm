//
// Maximum slice problem(MaxDoubleSliceSum)
// https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_double_slice_sum/
// Created by hyungwook on 2021/11/17.
//

public class Solution {

    public int solution(int[] A) {
        int length = A.length;
        int answer = Integer.MIN_VALUE;
        int[] frontSum = new int[length];
        int[] backSum = new int[length];

        for (int i = 1; i < length - 2; i++) {
            frontSum[i] = Math.max(0, frontSum[i - 1] + A[i]);
        }
        for (int i = length - 2; i >= 2; i--) {
            backSum[i] = Math.max(0, backSum[i + 1] + A[i]);
        }
        for (int i = 1; i < length - 1; i++) {
            answer = Math.max(answer, frontSum[i - 1] + backSum[i + 1]);
        }

        return answer;
    }
}