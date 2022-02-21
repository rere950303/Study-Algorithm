//
// Algorithmic skills(DisappearingPairs)
// https://app.codility.com/programmers/trainings/4/disappearing_pairs/
// Created by hyungwook on 2022/02/18.
//

import java.util.Stack;

public class Solution {

    public String solution(String S) {
        Stack<Character> stack = new Stack<>();

        for (char c : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.add(c);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        int size = stack.size();

        for (int i = 0; i < size; i++) {
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.reverse().toString();
    }
}