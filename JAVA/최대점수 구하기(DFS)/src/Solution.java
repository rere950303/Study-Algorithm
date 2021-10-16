//
// 최대점수 구하기(DFS)
//
// Created by hyungwook on 2021/10/06.
//

import java.util.Scanner;

public class Solution {

    static int n;
    static int m;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        dfs(arr, 0, 0, 0);

        System.out.println(answer);
    }

    private static void dfs(int[][] arr, int time, int score, int num) {
        if (time > m) {
            return;
        }
        if (num == n) {
            answer = Math.max(answer, score);
        } else {
            dfs(arr, time + arr[num][1], score + arr[num][0], num + 1);
            dfs(arr, time, score, num + 1);
        }
    }
}