//
// 이분검색
//
// Created by hyungwook on 2021/09/30.
//

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int pl = 0;
        int pr = n - 1;


        while (pl <= pr) {
            int pc = (pl + pr) / 2;

            if (arr[pc] == m) {
                answer = pc;
                break;
            } else if (arr[pc] > m) {
                pr = pc - 1;
            } else {
                pl = pc + 1;
            }
        }

        System.out.println(answer + 1);
    }
}
