//
// 중복 확인
//
// Created by hyungwook on 2021/09/28.
//

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        String answer = "U";
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                answer = "D";
                break;
            }
        }

        System.out.println(answer);
    }
}
