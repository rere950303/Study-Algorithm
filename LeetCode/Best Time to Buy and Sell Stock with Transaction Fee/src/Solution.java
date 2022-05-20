//
// DP, Greedy(Best Time to Buy and Sell Stock with Transaction Fee)
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
// Created by hyungwook on 2022/05/09.
//

public class Solution {

    public int maxProfit(int[] prices, int fee) {
        int cash = 0;
        int hold = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            int cashTmp = cash;
            int holdTmp = hold;

            cash = Math.max(cashTmp, holdTmp + prices[i] - fee);
            hold = Math.max(holdTmp, cashTmp - prices[i]);
        }

        return cash;
    }
}