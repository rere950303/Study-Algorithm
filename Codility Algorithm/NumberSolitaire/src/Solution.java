//
// Dynamic programming(NumberSolitaire)
// https://app.codility.com/programmers/lessons/17-dynamic_programming/number_solitaire/
// Created by hyungwook on 2022/01/30.
//

import java.util.Arrays;

public class Solution {

    public int solution(int[] A) {
        int length = A.length;
        int[] dp = new int[length];
        Arrays.fill(dp ,Integer.MIN_VALUE);

        dp[0] = A[0];

        for (int i = 1; i < length; i++) {
            for (int j = 1; j <= 6; j++) {
                int k = i - j;
                if (k >= 0) {
                    dp[i] = Math.max(dp[k] + A[i], dp[i]);
                }
            }
        }

        return dp[length - 1];
    }
}
