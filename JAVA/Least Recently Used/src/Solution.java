//
// Least Recently Used
//
// Created by hyungwook on 2021/09/28.
//

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] answer = new int[s];
        boolean[] check = new boolean[101];
        int count = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (check[arr[i]] == false) {
                check[arr[i]] = true;
                answer[count++] = arr[i];
                if (count == s) {
                    break;
                }
            }
        }

        Arrays.stream(answer).forEach((i) -> System.out.print(i + " "));
    }
}
