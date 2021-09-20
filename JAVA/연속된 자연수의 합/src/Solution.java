/**
* 연속된 자연수의 합
*
* Created by hyungwook on 2021/09/20.
**/

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        int pl = 1;
        int pr = 1;
        int sum = 0;

        while (pl <= n / 2) {
            if (sum < n) {
                sum += pr++;
            } else if (sum == n) {
                answer++;
                sum += pr++ - pl++;
            } else {
                sum -= pl++;
            }
        }

//        for (int i = 1; i <= n / 2 + 1; i++) {
//            sum += i;
//            if (sum == n) {
//                answer++;
//            }
//            while (sum >= n) {
//                sum -= pl++;
//                if (sum == n) {
//                    answer++;
//                }
//            }
//        }

        System.out.println(answer);
    }
}
