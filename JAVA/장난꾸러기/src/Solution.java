//
// 장난꾸러기
//
// Created by hyungwook on 2021/09/29.
//

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pc = 0;
        int n = sc.nextInt();
        int[] answer = new int[2];
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr2[i] = arr1[i] = sc.nextInt();
        }

        Arrays.sort(arr1);

        for (int i = 0; i < n; i++) {
            if (arr1[i] != arr2[i]) {
                answer[pc++] = i + 1;
            }
        }

        Arrays.stream(answer).forEach((i) -> System.out.print(i + " "));
    }
}
