//
// Maximum slice problem(MaxProfit)
// https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_profit/
// Created by hyungwook on 2021/11/15.
//

public class Solution {

    public int solution(int[] A) {
        int length = A.length;
        if (length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int minNum = A[0];

        for (int i = 1; i < length; i++) {
            if (A[i] < minNum) {
                minNum = A[i];
            }
            max = Math.max(max, A[i] - minNum);
        }

        if (max <= 0) {
            return 0;
        } else {
            return max;
        }
    }
}