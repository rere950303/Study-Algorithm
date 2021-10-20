//
// 동전교환(냅색 알고리즘)
//
// Created by hyungwook on 2021/10/20.
//

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] dp = new int[m + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= m; j++) {
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }

        System.out.println(dp[m]);
    }
}