/**
* 격자판 최대합
* 
* Created by hyungwook on 2021/09/15.
**/

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] ints = new int[n][n];
        int max = 0;
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ints[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum1 += ints[i][j];
                sum2 += ints[j][i];
            }
            max = Math.max(max, Math.max(sum1, sum2));
            sum1 = sum2 = 0;
        }

        for (int i = 0; i < n; i++) {
            sum1 += ints[i][i];
            sum2 += ints[i][n - i - 1];
        }

        max = Math.max(max, Math.max(sum1, sum2));

        System.out.println(max);
    }
}
