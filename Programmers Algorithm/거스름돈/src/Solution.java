//
// DP(거스름돈)
// https://programmers.co.kr/learn/courses/30/lessons/12907
// Created by hyungwook on 2022/02/14.
//

import java.util.Arrays;

public class Solution {

    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        Arrays.sort(money);

        for (int m : money) {
            for (int i = 1; i <= n; i++) {
                if (i >= m) {
                    dp[i] = (dp[i] + dp[i - m]) % 1000000007;
                }
            }
        }

        return dp[n];
    }
}
