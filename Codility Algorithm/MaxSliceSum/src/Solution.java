//
// Maximum slice problem(MaxSliceSum)
// https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_slice_sum/
// Created by hyungwook on 2021/11/16.
//

public class Solution {

    public int solution(int[] A) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i : A) {
            max = Math.max(max, sum += i);
            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }
}
