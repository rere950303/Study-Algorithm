/**
* 연속 부분수열
*
* Created by hyungwook on 2021/09/19.
**/

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n + 1];
        int answer = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int pl = 0;
        int pr = 0;

        while (pr <= n) {
            if (sum > m) {
                sum -= arr[pl++];
            } else if (sum == m) {
                sum += arr[pr++] - arr[pl++];
                answer++;
            } else {
                sum += arr[pr++];
            }
        }

//        for (int i = 0; i < n; i++) {
//            sum += arr[i];
//            if (sum == m) {
//                answer++;
//            }
//            while (sum >= m) {
//                sum -= arr[pl++];
//                if (sum == m) {
//                    answer++;
//                }
//            }
//        }

        System.out.println(answer);
    }
}
