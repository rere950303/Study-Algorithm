/**
* 점수계산
*
* Created by hyungwook on 2021/09/14.
**/

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ints = new int[n];
        int answer = 0;
        int pc = 1;

        for (int i = 0; i < n; i++) {
            ints[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (ints[i] == 1) {
                answer += pc;
                pc++;
            } else {
                pc = 1;
            }
        }

        System.out.println(answer);
    }
}
