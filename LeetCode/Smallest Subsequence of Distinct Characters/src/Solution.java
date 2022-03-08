//
// String, Stack, Greedy(Smallest Subsequence of Distinct Characters)
// https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
// Created by hyungwook on 2022/03/06.
//

import java.util.Stack;

public class Solution {

    public String smallestSubsequence(String s) {
        int[] num = new int[26];
        Stack<Character> stack = new Stack<>();
        boolean[] isExist = new boolean[26];

        for (char c : s.toCharArray()) {
            num[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            num[c - 'a']--;
            if (isExist[c - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c && num[stack.peek() - 'a'] > 0) {
                isExist[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            isExist[c - 'a'] = true;
        }
        StringBuilder stringBuilder = new StringBuilder();

        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.reverse().toString();
    }
}