//
// 최대 부분 증가수열
//
// Created by hyungwook on 2021/10/20.
//

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            int tmp = 0;

            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    tmp = Math.max(tmp, dp[j]);
                }
            }
            dp[i] = tmp + 1;
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}