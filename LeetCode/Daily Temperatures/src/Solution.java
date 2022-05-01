//
// Stack(Daily Temperatures)
// https://leetcode.com/problems/daily-temperatures/
// Created by hyungwook on 2022/04/11.
//

import java.util.Stack;

public class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                Integer pre = stack.pop();
                answer[pre] = i - pre;
            }
            stack.add(i);
        }

        return answer;
    }
}