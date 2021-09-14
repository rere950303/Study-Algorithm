/**
* 뒤집은 소수
*
* Created by hyungwook on 2021/09/13.
**/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        List<Integer> prime = new ArrayList<>();
        getPrime(prime, 100000);

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            Integer integer = Integer.valueOf(new StringBuilder(String.valueOf(numbers[i])).reverse().toString());
            if (prime.contains(integer)) {
                System.out.printf("%d ", integer);
            }
        }
    }

    private static void getPrime(List<Integer> prime, int n) {
        prime.add(2);
        prime.add(3);
        int j;

        for (int i = 5; i <= n; i += 2) {
            int flag = 0;
            for (j = 1; prime.get(j) * prime.get(j) <= i; j++) {
                if (i % prime.get(j) == 0) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                prime.add(i);
            }
        }
    }
}