//
// 스택(짝지어 제거하기)
// https://programmers.co.kr/learn/courses/30/lessons/12973?language=java
// Created by hyungwook on 2022/02/02.
//

import java.util.Stack;

public class Solution {

    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty() == true ? 1 : 0;
    }
}