//
// Stack, String(Minimum Remove to Make Valid Parentheses)
// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
// Created by hyungwook on 2022/05/04.
//

import java.util.Stack;

public class Solution {

    public String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.add(i);
            } else if (chars[i] == ')') {
                if (stack.isEmpty()) {
                    chars[i] = '#';
                } else {
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) {
            chars[stack.pop()] = '#';
        }
        StringBuilder builder = new StringBuilder();

        for (char aChar : chars) {
            if (aChar != '#') {
                builder.append(aChar);
            }
        }

        return builder.toString();
    }
}
