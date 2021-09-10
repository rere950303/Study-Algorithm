/**
* 큰 수 출력하기
*
* Created by hyungwook on 2021/09/08.
**/

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ints = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            ints[i] = sc.nextInt();
        }

        for (int i = 1; i < n + 1; i++) {
            if (ints[i] > ints[i - 1]) {
                System.out.printf("%d ", ints[i]);
            }
        }
    }
}
