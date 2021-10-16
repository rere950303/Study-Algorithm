//
// 바둑이 승차(DFS)
//
// Created by hyungwook on 2021/10/06.
//

import java.util.Scanner;

public class Solution {

    static int c;
    static int n;
    static int sum = 0;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        dfs(arr, 0, 0);

        System.out.println(answer);
    }

    private static void dfs(int[] arr, int num, int sum) {
        if (sum > c) {
            return;
        }
        if (num == n) {
            answer = Math.max(answer, sum);
        } else {
            dfs(arr, num + 1, sum + arr[num]);
            dfs(arr, num + 1, sum);
        }
    }
}
