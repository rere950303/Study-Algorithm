//
// DP(멀리 뛰기)
// https://programmers.co.kr/learn/courses/30/lessons/12914?language=java
// Created by hyungwook on 2022/02/15.
//

public class Solution {

    public long solution(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        long[] dp = new long[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        return dp[n];
    }
}