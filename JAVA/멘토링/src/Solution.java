/**
* 멘토링
*
* Created by hyungwook on 2021/09/16.
**/

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] ints = new int[m + 1][n + 1];
        int answer = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                ints[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= n; i++) {
            int[] check = new int[n + 1];
            check[i] = -1;
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= n; k++) {
                    if (ints[j][k] == i) {
                        break;
                    } else {
                        check[ints[j][k]]++;
                    }
                }
            }

            answer += checkZero(check, n);
        }

        // 멘토멘티 가능한 모든 조합을 4중 반복문으로 구하는 방법 존재

        System.out.println(answer);
    }

    private static int checkZero(int[] check, int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (check[i] == 0) {
                count++;
            }
        }

        return count;
    }
}
