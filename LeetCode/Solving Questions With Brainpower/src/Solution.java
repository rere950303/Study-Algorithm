//
// DP, Array(Solving Questions With Brainpower)
// https://leetcode.com/problems/solving-questions-with-brainpower/
// Created by hyungwook on 2022/03/21.
//

public class Solution {

    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length + 1];

        for (int i = questions.length - 1; i >= 0; i--) {
            int next = i + questions[i][1] + 1;

            dp[i] = Math.max(dp[i + 1], next < questions.length ? dp[next] + questions[i][0] : questions[i][0]);
        }

        return dp[0];
    }
}