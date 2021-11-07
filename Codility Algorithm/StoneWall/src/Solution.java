//
// Stacks(StoneWall)
// https://app.codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/
// Created by hyungwook on 2021/11/06.
//

import java.util.Stack;

public class Solution {

    public int solution(int[] H) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i : H) {
            while (!stack.isEmpty() && stack.peek() > i) {
                stack.pop();
            }
            if (stack.isEmpty() || stack.peek() < i) {
                answer++;
                stack.push(i);
            }
        }

        return answer;
    }
}
