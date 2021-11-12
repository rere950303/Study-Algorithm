//
// Recursive, Stack(괄호 변환)
// https://programmers.co.kr/learn/courses/30/lessons/60058
// Created by hyungwook on 2021/11/12.
//

import java.util.Stack;

public class Solution {

    public String solution(String p) {
        return dfs(p);
    }

    private String dfs(String p) {
        if (p.equals("")) {
            return p;
        }

        int frontNum = 0;
        int backNum = 0;
        Stack<Character> stack = new Stack<>();
        String tmp = "";

        for (char c : p.toCharArray()) {
            if (c == '(') {
                tmp += c;
                frontNum++;
                stack.add(c);
            }
            if (c == ')') {
                tmp += c;
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
                backNum++;
            }
            if (frontNum == backNum) {
                break;
            }
        }

        if (stack.isEmpty()) {
            return tmp + dfs(p.substring(tmp.length(), p.length()));
        } else {
            String substring = tmp.substring(1, tmp.length() - 1);
            return "(" + dfs(p.substring(tmp.length(), p.length())) + ")" + reverse(substring);
        }
    }

    private String reverse(String substring) {
        String reg = "";

        for (char c : substring.toCharArray()) {
            if (c == '(') {
                reg += ')';
            } else {
                reg += '(';
            }
        }

        return reg;
    }
}
