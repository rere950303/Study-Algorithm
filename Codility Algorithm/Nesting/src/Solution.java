//
// Stacks(Nesting)
// https://app.codility.com/programmers/lessons/7-stacks_and_queues/nesting/
// Created by hyungwook on 2021/10/31.
//

import java.util.Stack;

public class Solution {

    public int solution(String S) {
        int flag = 0;
        int answer = 1;
        Stack<Character> stack = new Stack<>();
        char[] array = S.toCharArray();
        for (char c : array) {
            if (c == '(') {
                stack.add(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    flag = 1;
                    break;
                }
            }
        }

        if (flag == 1 || !stack.isEmpty()) {
            answer = 0;
        }

        return answer;
    }
}
