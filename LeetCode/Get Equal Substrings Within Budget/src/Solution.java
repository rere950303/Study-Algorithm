//
// String, Sliding Window, Two Pointer, Prefix Sum(Get Equal Substrings Within Budget)
// https://leetcode.com/problems/get-equal-substrings-within-budget/
// Created by hyungwook on 2022/03/06.
//

public class Solution {

    public int equalSubstring(String s, String t, int maxCost) {
        int length = s.length();
        int pl = 0;
        int pr = 0;
        int[] costArr = new int[length];
        int answer = 0;

        for (int i = 0; i < length; i++) {
            costArr[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int cost = 0;

        while (pr < length) {
            if (cost + costArr[pr] <= maxCost) {
                answer = Math.max(answer, pr - pl + 1);
                cost += costArr[pr];
                pr++;
            } else {
                cost = Math.max(0, cost - costArr[pl]);
                pl++;
            }
            if (pl > pr) {
                pr = pl;
            }
        }

        return answer;
    }
}