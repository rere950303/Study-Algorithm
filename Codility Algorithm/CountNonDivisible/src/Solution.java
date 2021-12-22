//
// Sieve of Eratosthenes(CountNonDivisible)
// https://app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/count_non_divisible/
// Created by hyungwook on 2021/11/30.
//

public class Solution {

    public int[] solution(int[] A) {
        int length = A.length;
        int[] arr = new int[length * 2 + 1];
        int[] answer = new int[length];

        for (int i : A) {
            arr[i]++;
        }

        for (int i = 0; i < length; i++) {
            int tmp = 0;
            for (int j = 1; j * j <= A[i]; j++) {
                if (A[i] % j == 0) {
                    tmp += arr[j];
                    if (A[i] / j != j) {
                        tmp += arr[A[i] / j];
                    }
                }
            }
            answer[i] = length - tmp;
        }

        return answer;
    }
}