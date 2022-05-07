//
// Stack, String, Greedy(Minimum Add to Make Parentheses Valid)
// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
// Created by hyungwook on 2022/05/05.
//

import java.util.Stack;

public class Solution {

    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.add(c);
            } else {
                if (stack.isEmpty() || stack.peek() != '(') {
                    stack.add(c);
                } else {
                    stack.pop();
                }
            }
        }

        return stack.size();
    }
}
