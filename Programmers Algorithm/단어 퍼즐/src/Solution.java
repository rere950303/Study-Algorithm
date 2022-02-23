//
// DP(단어 퍼즐)
// https://programmers.co.kr/learn/courses/30/lessons/12983?language=java
// Created by hyungwook on 2022/02/22.
//

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    public int solution(String[] strs, String t) {
        Set<String> set = Arrays.stream(strs).collect(Collectors.toSet());
        int length = t.length();
        int[] dp = new int[length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        int tmp = length < 5 ? length : 5;

        for (int i = 1; i <= tmp; i++) {
            if (set.contains(t.substring(0, i))) {
                dp[i] = 1;
            }
        }

        for (int i = 1; i <= length; i++) {
            int interval = i - 5 < 0 ? 0 : i - 5;

            for (int j = i; j >= interval; j--) {
                if (dp[j] < dp[i] - 1 && set.contains(t.substring(j, i))) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        return dp[length] == Integer.MAX_VALUE ? -1 : dp[length];
    }
}