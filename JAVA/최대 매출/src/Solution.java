/**
* 최대 매출
*
* Created by hyungwook on 2021/09/19.
**/

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < k; i++) {
            answer += arr[i];
        }

        int sum = answer;

        for (int i = 0; i < n - k; i++) {
            sum += arr[i + k] - arr[i];
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}