//
// 재귀함수(스택프레임)
//
// Created by hyungwook on 2021/10/02.
//

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dfs(1, n);
    }

    private static void dfs(int i, int n) {
        if (i <= n) {
            System.out.print(i + " ");
            dfs(i + 1, n);
        }
    }
}
