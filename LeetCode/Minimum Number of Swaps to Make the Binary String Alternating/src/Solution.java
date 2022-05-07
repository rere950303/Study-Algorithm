//
// Greedy, String(Minimum Number of Swaps to Make the Binary String Alternating)
// https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-binary-string-alternating/
// Created by hyungwook on 2022/05/02.
//

public class Solution {

    public int minSwaps(String s) {
        char[] chars = s.toCharArray();
        int zeroCount = 0;
        int oneCount = 0;

        for (char aChar : chars) {
            if (aChar == '0') {
                zeroCount++;
            } else {
                oneCount++;
            }
        }

        if (Math.abs(zeroCount - oneCount) > 1) {
            return -1;
        }

        int count1 = 0; // firstZero
        int count2 = 0; // firstOne
        int turn = 1; // 1 -> 0, -1 -> 1

        for (int i = 0; i < chars.length; i++) {
            if (turn == 1) {
                count1 += chars[i] != '0' ? 1 : 0;
                count2 += chars[i] != '1' ? 1 : 0;
            } else {
                count1 += chars[i] != '1' ? 1 : 0;
                count2 += chars[i] != '0' ? 1 : 0;
            }
            turn *= -1;
        }

        if (zeroCount == oneCount) {
            return Math.min(count1 / 2, count2 / 2);
        } else if (zeroCount > oneCount) {
            return count1 / 2;
        } else {
            return count2 / 2;
        }
    }
}