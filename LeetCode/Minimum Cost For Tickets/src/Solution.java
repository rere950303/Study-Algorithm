//
// DP, Array(Minimum Cost For Tickets)
// https://leetcode.com/problems/minimum-cost-for-tickets/
// Created by hyungwook on 2022/03/15.
//

public class Solution {

    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];
        boolean[] isTravelDay = new boolean[lastDay + 1];

        for (int day : days) {
            isTravelDay[day] = true;
        }

        for (int i = 1; i <= lastDay; i++) {
            if (!isTravelDay[i]) {
                dp[i] = dp[i - 1];
                continue;
            }
            int minCost = dp[i - 1] + costs[0];
            minCost = Math.min(dp[Math.max(0, i - 7)] + costs[1], minCost);
            minCost = Math.min(dp[Math.max(0, i - 30)] + costs[2], minCost);

            dp[i] = minCost;
        }

        return dp[lastDay];
    }
}