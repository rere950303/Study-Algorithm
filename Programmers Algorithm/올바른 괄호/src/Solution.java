//
// Stack(올바른 괄호)
// https://programmers.co.kr/learn/courses/30/lessons/12909?language=java
// Created by hyungwook on 2022/02/28.
//

import java.util.Stack;

public class Solution {

    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == ')' && stack.isEmpty()) {
                return false;
            } else if (c == ')') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty() ? true : false;
    }
}