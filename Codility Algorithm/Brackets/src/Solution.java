//
// Stack(Brackets)
// https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/
// Created by hyungwook on 2021/10/29.
//

import java.util.Stack;

public class Solution {

    public int solution(String S) {
        char[] array = S.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : array) {
            if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}