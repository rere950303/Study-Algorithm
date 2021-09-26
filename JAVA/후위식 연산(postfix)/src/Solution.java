//
// 후위식 연산(postfix)
//
// Created by hyungwook on 2021/09/24.
//

import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Stack<Integer> stack = new Stack<>();

        for (char x : s.toCharArray()) {
            if (Character.isDigit(x)) {
                stack.push(Character.getNumericValue(x));
            } else {
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                int num = calculate(pop1, pop2, x);
                stack.push(num);
            }
        }

        System.out.println(stack.pop());
    }

    private static int calculate(Integer pop1, Integer pop2, char x) {
        switch (x) {
            case '+':
                return pop1 + pop2;
            case '-':
                return pop2 - pop1;
            case '*':
                return pop1 * pop2;
            case '/':
                return pop2 / pop1;
            default:
                return 0;
        }
    }
}
