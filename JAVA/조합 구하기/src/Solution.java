//
// 조합 구하기
//
// Created by hyungwook on 2021/10/10.
//

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static int n;
    static int m;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        check = new boolean[n + 1];

        int[] arr = new int[m];
        dfs(0, 1, arr);
    }

    private static void dfs(int L, int start, int[] arr) {
        if (L == m) {
            Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
            System.out.println();
        } else {
            for (int i = start; i <= n; i++) {
                if (!check[i]) {
                    check[i] = true;
                    arr[L] = i;
                    dfs(L + 1, i + 1, arr);
                    check[i] = false;
                }
            }
        }
    }
}