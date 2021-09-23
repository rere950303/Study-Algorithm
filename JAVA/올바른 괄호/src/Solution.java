//
// 올바른 괄호
//
// Created by hyungwook on 2021/09/23.
//

import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        String answer = "YES";
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    answer = "NO";
                    break;
                } else {
                    stack.pop();
                }
            }
        }

        if (!stack.isEmpty()) {
            answer = "NO";
        }

        System.out.println(answer);
    }
}
