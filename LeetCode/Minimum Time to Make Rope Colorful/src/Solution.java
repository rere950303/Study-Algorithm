//
// Greedy, String, Array(Minimum Time to Make Rope Colorful)
// https://leetcode.com/problems/minimum-time-to-make-rope-colorful/
// Created by hyungwook on 2022/03/18.
//

public class Solution {

    public int minCost(String colors, int[] neededTime) {
        char[] chars = colors.toCharArray();
        int answer = 0;

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                int sum = neededTime[i];
                int max = sum;

                while (i < chars.length - 1 && chars[i] == chars[i + 1]) {
                    sum += neededTime[i + 1];
                    max = Math.max(max, neededTime[i + 1]);
                    i++;
                }

                answer += sum - max;
            }
        }

        return answer;
    }
}