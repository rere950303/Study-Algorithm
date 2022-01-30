//
// Euclidean algorithm(CommonPrimeDivisors)
// https://app.codility.com/programmers/lessons/12-euclidean_algorithm/common_prime_divisors/
// Created by hyungwook on 2022/01/25.
//

public class Solution {

    public int solution(int[] A, int[] B) {
        int answer = 0;
        int length = A.length;

        for (int i = 0; i < length; i++) {
            int a = A[i];
            int b = B[i];

            if (check(a, b) && check(b, a)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean check(int fix, int notFix) {
        int gcd = gcd(fix, notFix);

        if (gcd == 1) {
            return notFix == 1 ? true : false;
        }

        return check(fix, notFix / gcd);
    }

    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}