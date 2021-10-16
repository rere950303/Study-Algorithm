//
// 부분집합 구하기(DFS)
//
// Created by hyungwook on 2021/10/04.
//

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] check = new boolean[n + 1];

        dfs(check, n, 1);
    }

    private static void dfs(boolean[] check, int n, int i) {
        if (i == n + 1) {
            print(check, n);
        } else {
            check[i] = true;
            dfs(check, n, i + 1);
            check[i] = false;
            dfs(check, n, i + 1);
        }
    }

    private static void print(boolean[] check, int n) {
        String tmp = "";

        for (int i = 1; i <= n; i++) {
            if (check[i]) {
                tmp += (i + " ");
            }
        }

        if (tmp.length() > 0) {
            System.out.println(tmp);
        }
    }
}