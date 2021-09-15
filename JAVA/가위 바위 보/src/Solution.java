/**
* 가위 바위 보
*
* Created by hyungwook on 2021/09/10.
**/

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];

        input(sc, n, A);
        input(sc, n, B);

        for (int i = 0; i < n; i++) {
            if (A[i] - B[i] == 1 || A[i] - B[i] == -2) {
                System.out.println("A");
            } else if (A[i] - B[i] == -1 || A[i] - B[i] == 2) {
                System.out.println("B");
            } else {
                System.out.println("D");
            }
        }
    }

    private static void input(Scanner sc, int n, int[] input) {
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
    }
}
