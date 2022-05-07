//
// Stack, String(Score of Parentheses)
// https://leetcode.com/problems/score-of-parentheses/
// Created by hyungwook on 2022/05/03.
//

import java.util.Stack;

public class Solution {

    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        stack.add(0);

        for (char aChar : chars) {
            if (aChar == '(') {
                stack.add(0);
            } else {
                int top = stack.pop();
                int prev = stack.pop();

                stack.add(prev + Math.max(top * 2, 1));
            }
        }

        return stack.pop();
    }
}