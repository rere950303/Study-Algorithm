//
// 선택 정렬
//
// Created by hyungwook on 2021/09/27.
//

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int pc = i;
            while (pc > 0 && arr[pc - 1] > temp) {
                arr[pc] = arr[pc - 1];
                pc--;
            }
            arr[pc] = temp;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
