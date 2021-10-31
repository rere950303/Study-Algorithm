//
// Stack(Fish)
// https://app.codility.com/programmers/lessons/7-stacks_and_queues/fish/
// Created by hyungwook on 2021/10/29.
//

import java.util.Stack;

public class Solution {

    public int solution(int[] A, int[] B) {
        Stack<Integer> stack = new Stack<>();
        int length = A.length;
        int alive = 0;

        for (int i = 0; i < length; i++) {
            if (B[i] == 1) {
                stack.add(A[i]);
            } else {
                while (!stack.isEmpty()) {
                    if (stack.peek() > A[i]) {
                        break;
                    } else {
                        stack.pop();
                    }
                }
                if (stack.isEmpty()) {
                    alive++;
                }
            }
        }

        return stack.size() + alive;
    }
}
