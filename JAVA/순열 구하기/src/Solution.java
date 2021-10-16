//
// 순열 구하기
//
// Created by hyungwook on 2021/10/10.
//

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static int[] arr;
    static int n;
    static int m;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        check = new boolean[n];
        int[] tmp = new int[2];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        dfs(0, tmp);
    }

    private static void dfs(int L, int[] tmp) {
        if (L == m) {
            print(tmp);
        } else {
            for (int i = 0; i < n; i++) {
                if (!check[i]) {
                    tmp[L] = arr[i];
                    check[i] = true;
                    dfs(L + 1, tmp);
                    check[i] = false;
                }
            }
        }
    }

    private static void print(int[] tmp) {
        Arrays.stream(tmp).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }
}