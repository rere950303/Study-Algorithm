//
// Sliding Window, Array, DP(Longest Turbulent Subarray)
// https://leetcode.com/problems/longest-turbulent-subarray/
// Created by hyungwook on 2022/05/13.
//

public class Solution {

    public int maxTurbulenceSize(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        if (arr.length == 2) {
            return arr[0] == arr[1] ? 1 : 2;
        }

        int flag = 0;
        int answer = 1;
        int max = 1;

        for (int i = 1; i < arr.length; i++) {
            int turbulent = arr[i] - arr[i - 1];

            if (turbulent == 0) {
                flag = 0;
                max = 1;
            } else if (turbulent > 0) {
                if (flag <= 0) {
                    max++;
                } else {
                    max = 2;
                }
                flag = 1;
            } else {
                if (flag >= 0) {
                    max++;
                } else {
                    max = 2;
                }
                flag = -1;
            }

            answer = Math.max(answer, max);
        }

        return answer;
    }
}