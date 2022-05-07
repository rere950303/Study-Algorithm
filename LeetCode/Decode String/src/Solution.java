//
// Stack, String(Decode String)
// https://leetcode.com/problems/decode-string/
// Created by hyungwook on 2022/05/01.
//

import java.util.Stack;

public class Solution {

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();

        for (char aChar : chars) {
            if (aChar == ']') {
                while (stack.peek() != '[') {
                    builder.insert(0, stack.pop());
                }
                stack.pop();
                int count = 0;
                int radix = 1;

                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    count += radix * (stack.pop() - '0');
                    radix *= 10;
                }
                for (int i = 0; i < count; i++) {
                    char[] chars1 = builder.toString().toCharArray();

                    for (char c : chars1) {
                        stack.add(c);
                    }
                }
                builder.setLength(0);
            } else {
                stack.push(aChar);
            }
        }

        builder.setLength(0);

        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }

        return builder.toString();
    }
}