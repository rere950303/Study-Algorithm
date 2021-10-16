//
// 수열 추측하기
//
// Created by hyungwook on 2021/10/10.
//

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static int n;
    static int f;
    static boolean check[];
    static int flag = 0;
    static int[] arr;
    static int combination[];
    static int[][] dy = new int[11][11];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt();
        arr = new int[n];
        combination = new int[n];
        check = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            combination[i] = comb(n - 1, i);
        }

        dfs(0, 0);
    }

    private static int comb(int n, int r) {
        if (dy[n][r] != 0) {
            return dy[n][r];
        }
        if (r == 1) {
            return n;
        }
        if (n == r || r == 0) {
            return 1;
        } else {
            return dy[n][r] = comb(n - 1, r - 1) + comb(n - 1, r);
        }
    }

    private static void dfs(int L, int sum) {
        if (flag == 1) {
            return;
        }
        if (L == n) {
            if (sum == f) {
                flag = 1;
                Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (!check[i]) {
                    check[i] = true;
                    arr[L] = i;
                    dfs(L + 1, sum + arr[L] * combination[L]);
                    check[i] = false;
                }
            }
        }
    }
}