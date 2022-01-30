//
// 스택(n진수 게임)
// https://programmers.co.kr/learn/courses/30/lessons/17687?language=java
// Created by hyungwook on 2022/01/20.
//

import java.util.Stack;

public class Solution {

    static char[] numeralSystem = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public String solution(int n, int t, int m, int p) {
        int num = 0;
        int pc = p - 1;
        int count = 0;
        Stack<Character> stack = new Stack<>();
        StringBuffer answer = new StringBuffer();

        while (t > 0) {
            if (stack.isEmpty()) {
                getSample(stack, n, num);
                num++;
            }
            if (pc == count) {
                pc += m;
                answer.append(stack.peek());
                t--;
            }

            stack.pop();
            count++;
        }

        return answer.toString();
    }

    private void getSample(Stack<Character> stack, int n, int num) {
        while (num >= n) {
            int radix = num % n;
            stack.add(numeralSystem[radix]);
            num /= n;
        }
        stack.add(numeralSystem[num]);
    }
}