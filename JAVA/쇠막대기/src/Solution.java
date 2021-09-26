//
// 쇠막대기
//
// Created by hyungwook on 2021/09/25.
//

import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        int flag = 0;

        for (char x : str.toCharArray()) {
            if (x == '(') {
                flag = 0;
                stack.push(x);
            } else {
                if (flag == 1) {
                    stack.pop();
                    answer++;
                } else {
                    stack.pop();
                    answer += stack.size();
                    flag = 1;
                }
            }
        }

        System.out.println(answer);
    }
}
