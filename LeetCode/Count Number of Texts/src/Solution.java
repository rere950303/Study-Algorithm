//
// DP, String, Math(Count Number of Texts)
// https://leetcode.com/problems/count-number-of-texts/
// Created by hyungwook on 2022/06/03.
//

public class Solution {

    public int countTexts(String pressedKeys) {
        int modulo = (int) (Math.pow(10, 9) + 7);
        int[] dp = new int[pressedKeys.length() + 1];

        dp[0] = 1;
        for (int i = 1; i <= pressedKeys.length(); i++) {
            int count = 3;
            char c = pressedKeys.charAt(i - 1);

            if (c == '7' || c == '9') {
                count = 4;
            }
            for (int j = i - 1; j >= Math.max(0, i - count); j--) {
                if (pressedKeys.charAt(j) != pressedKeys.charAt(i - 1)) {
                    break;
                }
                dp[i] = (dp[i] + dp[j]) % modulo;
            }
        }

        return dp[pressedKeys.length()];
    }
}