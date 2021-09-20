/**
* 최대 길이 연속부분수열
*
* Created by hyungwook on 2021/09/20.
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

        for (int i = 0; i < n; i++) {
            int temp = 0;
            int count = 0;
            int pc = i;
            while (pc < n && count <= k) {
                if (arr[pc] == 1) {
                    temp++;
                    pc++;
                } else {
                    temp++;
                    count++;
                    pc++;
                }
            }
            answer = Math.max(answer, temp - 1);
        }

//        2포인트 알고리즘
//        for (int i = 0; i < n; i++) {
//            if (arr[i] == 0) {
//                count++;
//            }
//            while (count > k) {
//                if (arr[lt] == 0) {
//                    count--;
//                }
//                lt++;
//            }
//            answer = Math.max(answer, i - lt + 1);
//        }

        System.out.println(answer);
    }
}
