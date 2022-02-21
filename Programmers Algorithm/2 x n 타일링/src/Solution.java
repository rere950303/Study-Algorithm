//
// DP(2 x n 타일링)
// https://programmers.co.kr/learn/courses/30/lessons/12900
// Created by hyungwook on 2022/02/06.
//

public class Solution {

    public int solution(int n) {
        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }

        return dp[n];
    }
}