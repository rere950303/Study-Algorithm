//
// DP(Best Time to Buy and Sell Stock with Cooldown)
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
// Created by hyungwook on 2022/05/09.
//

public class Solution {

    public int maxProfit(int[] prices) {
        int cashP = 0;
        int cash = 0;
        int hold = -prices[0];
        boolean flag = false;

        for (int i = 1; i < prices.length; i++) {
            int cashTmp = cash;
            int holdTmp = hold;

            if (flag) {
                hold = Math.max(hold, cashP - prices[i]);
                flag = false;
            }
            hold = Math.max(hold, cashTmp - prices[i]);

            if (cashTmp < holdTmp + prices[i]) {
                flag = true;
                cash = holdTmp + prices[i];
            }

            cashP = cashTmp;
        }

        return cash;
    }
}