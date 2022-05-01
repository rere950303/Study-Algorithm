//
// DP(Super Ugly Number)
// https://leetcode.com/problems/super-ugly-number/
// Created by hyungwook on 2022/04/08.
//

public class Solution {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;
        int[] index = new int[primes.length];

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, primes[j] * dp[index[j]]);
            }
            dp[i] = min;
            for (int j = 0; j < primes.length; j++) {
                if (dp[i] == primes[j] * dp[index[j]]) {
                    index[j]++;
                }
            }
        }

        return dp[n - 1];
    }
}