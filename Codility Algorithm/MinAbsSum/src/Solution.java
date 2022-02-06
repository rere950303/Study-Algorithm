//
// Dynamic programming(MinAbsSum)
// https://app.codility.com/programmers/lessons/17-dynamic_programming/min_abs_sum/
// Created by hyungwook on 2022/02/01.
//

import java.util.Arrays;

public class Solution {

    public int solution(int[] A) {
        int length = A.length;

        if (length == 0) {
            return 0;
        }

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < length; i++) {
            A[i] = Math.abs(A[i]);
            sum += A[i];
            max = Math.max(max, A[i]);
        }

        int[] dp = new int[sum + 1];
        int[] num = new int[max + 1];

        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int a : A) {
            num[a]++;
        }

        for (int i = 0; i <= max; i++) {
            if (num[i] > 0) {
                for (int j = 0; j <= sum; j++) {
                    if (dp[j] >= 0) {
                        dp[j] = num[i];
                    } else if (j - i >= 0 && dp[j - i] > 0) {
                        dp[j] = dp[j - i] - 1;
                    }
                }
            }
        }

        int answer = sum;

        for (int i = 0; i <= sum / 2; i++) {
            if (dp[i] >= 0) {
                answer = Math.min(answer, sum - 2 * i);
            }
        }

        return answer;
    }
}
