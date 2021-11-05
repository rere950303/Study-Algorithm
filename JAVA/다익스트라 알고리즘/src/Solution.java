//
// 다익스트라 알고리즘
//
// Created by hyungwook on 2021/10/31.
//

import java.util.Scanner;

public class Solution {

    static boolean[] check;
    static int n;
    static int[][] arr;
    static int answer = Integer.MAX_VALUE;
    static int flag = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n + 1][n + 1];
        check = new boolean[n + 1];
        check[1] = true;

        for (int i = 0; i < m; i++) {
            arr[sc.nextInt()][sc.nextInt()] = sc.nextInt();
        }

        for (int i = 2; i <= n; i++) {
            dfs(1, i, 0);
            if (flag == 1) {
                System.out.println(answer);
            } else {
                System.out.println("impossible");
            }
            flag = 0;
            answer = Integer.MAX_VALUE;
        }
    }

    private static void dfs(int start, int node, int sum) {
        if (start == node) {
            flag = 1;
            answer = Math.min(answer, sum);
        } else {
            for (int i = 1; i <= n; i++) {
                if (!check[i] && arr[start][i] != 0) {
                    check[i] = true;
                    dfs(i, node, sum + arr[start][i]);
                    check[i] = false;
                }
            }
        }
    }
}