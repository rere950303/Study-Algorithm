/**
* 피보나치 수열
*
* Created by hyungwook on 2021/09/11.
**/

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ints = new int[n];
        ints[0] = ints[1] = 1;

        for (int i = 2; i < n; i++) {
            ints[i] = ints[i - 1] + ints[i - 2];
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", ints[i]);
        }
    }
}
