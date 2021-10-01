//
// 마구간 정하기(결정알고리즘)
//
// Created by hyungwook on 2021/10/01.
//

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int pl = 1;
        int pr = arr[n - 1] - arr[0];

        while (pl <= pr) {
            int pc = (pl + pr) / 2;
            int num = horseNum(arr, pc, n);

            if (num >= c) {
                answer = pc;
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }
        }

        System.out.println(answer);
    }

    private static int horseNum(int[] arr, int pc, int n) {
        int count = 1;
        int start = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] - start >= pc) {
                count++;
                start = arr[i];
            }
        }

        return count;
    }
}
