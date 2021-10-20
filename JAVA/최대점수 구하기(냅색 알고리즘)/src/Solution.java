//
// 최대점수 구하기(냅색 알고리즘)
//
// Created by hyungwook on 2021/10/20.
//

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dp = new int[m + 1];
        Problem[] problems = new Problem[n];

        for (int i = 0; i < n; i++) {
            problems[i] = new Problem(sc.nextInt(), sc.nextInt());
        }

        for (int i = 0; i < n; i++) {
            for (int j = m; j >= problems[i].t; j--) {
                dp[j] = Math.max(dp[j], problems[i].s + dp[j - problems[i].t]);
            }
        }

        System.out.println(dp[m]);
    }

    static class Problem {
        int s;
        int t;

        public Problem(int s, int t) {
            this.s = s;
            this.t = t;
        }
    }
}