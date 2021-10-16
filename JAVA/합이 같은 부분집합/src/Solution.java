//
// 합이 같은 부분집합
//
// Created by hyungwook on 2021/10/06.
//

import java.util.Scanner;

public class Solution {

    static int n;
    static boolean flag;
    static int total = 0;
    static String answer = "NO";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        dfs(arr, 0, 0);

        System.out.println(answer);
    }

    private static void dfs(int[] arr, int sum, int num) {
        if (flag) {
            return;
        }
        if (sum > total / 2) {
            return;
        }
        if (num == n) {
            if (sum == total - sum) {
                flag = true;
                answer = "YES";
            }
        } else {
            dfs(arr, sum + arr[num], num + 1);
            dfs(arr, sum, num + 1);
        }
    }
}