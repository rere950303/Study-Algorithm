//
// 동전교환
//
// Created by hyungwook on 2021/10/09.
//

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    static int n;
    static Integer[] arr;
    static int m;
    static int answer = Integer.MAX_VALUE;
    static int flag = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        m = sc.nextInt();
        Arrays.sort(arr, Collections.reverseOrder());

        dfs(0, 0);

        System.out.println(answer);
    }

    private static void dfs(int L, int sum) {
        if (sum > m) {
            return;
        }
        if (L >= answer) {
            return;
        }
        if (sum == m) {
            answer = Math.min(answer, L);
            return;
        }
        for (int i = 0; i < n; i++) {
            dfs(L + 1, sum + arr[i]);
        }
    }
}