//
// Math, Array(Number of Smooth Descent Periods of a Stock)
// https://leetcode.com/problems/number-of-smooth-descent-periods-of-a-stock/
// Created by hyungwook on 2022/03/29.
//

public class Solution {

    public long getDescentPeriods(int[] prices) {
        long answer = 1;
        long contiguousDays = 1;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] + 1 == prices[i - 1]) {
                answer += ++contiguousDays;
            } else {
                answer += contiguousDays = 1;
            }
        }

        return answer;
    }
}