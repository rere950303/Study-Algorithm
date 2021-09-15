/**
* 등수구하기
*
* Created by hyungwook on 2021/09/14.
**/

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ints = new int[n];
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            ints[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int temp = ints[i];
            for (int j = 0; j < n; j++) {
                if (ints[j] < temp) {
                    answer[j]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", answer[i]);
        }
    }
}
