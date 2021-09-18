/**
* 임시반장 정하기
*
* Created by hyungwook on 2021/09/16.
**/

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] ints = new int[n][5];
        int max = 0;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                ints[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 5; k++) {
                    if (ints[i][k] == ints[j][k]) {
                        count++;
                        break;
                    }
                }
            }

            if (max < count) {
                max = count;
                answer = i + 1;
            }
        }

        System.out.println(answer);
    }
}
