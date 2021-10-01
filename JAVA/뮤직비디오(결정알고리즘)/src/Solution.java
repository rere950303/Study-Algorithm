//
// 뮤직비디오(결정알고리즘)
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

        int pl = Arrays.stream(arr).min().getAsInt();
        int pr = Arrays.stream(arr).sum();

        while (pl <= pr) {
            int pc = (pl + pr) / 2;
            int count = countDVD(arr, pc, n);

            if (count > m) {
                pl = pc + 1;
            } else {
                answer = pc;
                pr = pc - 1;
            }
        }

        System.out.println(answer);
    }

    private static int countDVD(int[] arr, int pc, int n) {
        int count = 1;
        int temp = 0;

        for (int i : arr) {
            if (temp + i > pc) {
                count++;
                temp = i;
            } else {
                temp += i;
            }
        }
        return count;
    }
}
