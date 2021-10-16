//
// 조합의 경우수(메모이제이션)
//
// Created by hyungwook on 2021/10/10.
//

import java.util.Scanner;

public class Solution {

    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        arr = new int[n + 1][r + 1];

        int answer = dfs(n, r);

        System.out.println(answer);
    }

    private static int dfs(int n, int r) {
        if (arr[n][r] != 0) {
            return arr[n][r];
        }
        if (r == 1) {
            arr[n][r] = n;
            return n;
        }
        if (n == r) {
            arr[n][r] = 1;
            return 1;
        }

        return arr[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r);
    }
}