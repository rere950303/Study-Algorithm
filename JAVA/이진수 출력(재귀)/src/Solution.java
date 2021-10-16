//
// 이진수 출력(재귀)
//
// Created by hyungwook on 2021/10/02.
//

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dfs(n);
    }

    private static void dfs(int n) {
        if (n > 0) {
            dfs(n / 2);
            System.out.print(n % 2);
        }
    }
}
