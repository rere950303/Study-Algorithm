//
// 스택(괄호 회전하기)
// https://programmers.co.kr/learn/courses/30/lessons/76502
// Created by hyungwook on 2022/02/05.
//

import java.util.Stack;

public class Solution {

    public int solution(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        int answer = 0;
        int length = s.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            stringBuilder = stringBuilder.append(stringBuilder.charAt(0)).deleteCharAt(0);

            for (char c : stringBuilder.toString().toCharArray()) {
                if (stack.isEmpty()) {
                    stack.add(c);
                } else {
                    if (c == ']' && stack.peek() == '[') {
                        stack.pop();
                    } else if (c == '}' && stack.peek() == '{') {
                        stack.pop();
                    } else if (c == ')' && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.add(c);
                    }
                }
            }

            if (stack.isEmpty()) {
                answer++;
            }
            stack.clear();
        }

        return answer;
    }
}