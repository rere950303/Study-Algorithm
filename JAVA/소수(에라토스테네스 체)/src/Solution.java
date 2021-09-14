/**
* 소수(에라토스테네스 체)
*
* Created by hyungwook on 2021/09/11.
**/

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prime = new int[n / 2];
        prime[0] = 2;
        prime[1] = 3;
        int count = 2;
        int j = 1;

        for (int i = 5; i <= n; i += 2) {
            int flag = 0;
            for (j = 1; prime[j] * prime[j] <= i; j++) {
                if (i % prime[j] == 0) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                prime[count++] = i;
            }
        }

        if (n == 2) {
            System.out.println(1);
        } else {
            System.out.println(count);
        }
    }
}
