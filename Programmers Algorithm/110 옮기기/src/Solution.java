//
// 스택(110 옮기기)
// https://programmers.co.kr/learn/courses/30/lessons/77886
// Created by hyungwook on 2022/02/11.
//

import java.util.Stack;

public class Solution {

    public String[] solution(String[] s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length;

        for (int i = 0; i < length; i++) {
            String target = s[i];
            char first = '0';
            char second = '0';
            int num = 0;

            for (char c : target.toCharArray()) {
                if (first == '1' && second == '1' && c == '0') {
                    stack.pop();
                    stack.pop();

                    if (stack.size() >= 2) {
                        second = stack.pop();
                        first = stack.pop();
                        stack.add(first);
                        stack.add(second);
                    } else if (stack.size() == 1) {
                        second = stack.peek();
                        first = '0';
                    } else {
                        first = '0';
                        second = '0';
                    }

                    num++;
                } else {
                    first = second;
                    second = c;
                    stack.add(c);
                }
            }

            StringBuilder stringBuilder = new StringBuilder();
            int size = stack.size();
            int idx = 0;

            for (int j = size; j > 0; j--) {
                Character pop = stack.pop();
                if (pop == '0') {
                    idx = Math.max(idx, j);
                }
                stringBuilder.append(pop);
            }

            stringBuilder.reverse();

            for (int j = 0; j < num; j++) {
                stringBuilder.insert(idx, "110");
            }

            s[i] = stringBuilder.toString();
        }

        return s;
    }
}