//
// 크레인 인형뽑기
//
// Created by hyungwook on 2021/09/24.
//

import java.util.Scanner;
import java.util.Stack;

public class Solution {

    static int[][] arr1;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        n = sc.nextInt();
        arr1 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr1[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int num = pullDoll(arr2[i] - 1);
            if (!stack.isEmpty() && stack.peek() == num) {
                stack.pop();
                answer += 2;
            } else {
                stack.add(num);
            }
        }

        System.out.println(answer);
    }

    private static int pullDoll(int i) {
        int num = 0;

        for (int j = 0; j < n; j++) {
            if (arr1[j][i] != 0) {
                num = arr1[j][i];
                arr1[j][i] = 0;
                return num;
            }
        }

        return num;
    }
}
