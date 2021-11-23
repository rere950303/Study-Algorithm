//
// 규칙 찾기(표 편집)
// https://programmers.co.kr/learn/courses/30/lessons/81303
// Created by hyungwook on 2021/11/21.
//

import java.util.Stack;

public class Solution {

    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> stack = new Stack<>();
        int lastIndex = n - 1;

        for (String s : cmd) {
            char c = s.charAt(0);
            if (c == 'D') {
                k += Integer.valueOf(s.substring(2));
            } else if (c == 'U') {
                k -= Integer.valueOf(s.substring(2));
            } else if (c == 'C') {
                if (k == lastIndex) {
                    stack.add(k);
                    lastIndex--;
                    k = lastIndex;
                } else {
                    stack.add(k);
                    lastIndex--;
                }
            } else {
                if (stack.peek() <= k) {
                    stack.pop();
                    lastIndex++;
                    k++;
                } else {
                    stack.pop();
                    lastIndex++;
                }
            }
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i <= lastIndex; i++) {
            answer.append("O");
        }

        while (!stack.isEmpty()) {
            answer.insert(stack.pop(), "X");
        }

        return answer.toString();
    }
}