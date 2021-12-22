//
// Sieve of Eratosthenes(CountSemiprimes)
// https://app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/count_semiprimes/
// Created by hyungwook on 2021/12/01.
//

public class Solution {

    public int[] solution(int N, int[] P, int[] Q) {
        int length = P.length;
        int[] answer = new int[length];

        if (N == 1) {
            return answer;
        }

        int[] primes = new int[N];
        primes[0] = 2;
        int count = getPrime(primes, N);
        int[] arr = new int[N + 1];

        for (int i = 0; i < count; i++) {
            int prime = primes[i];
            int pc = 2;

            arr[prime * 1] = 1;
            while (pc * prime <= N) {
                arr[pc++ * prime] = prime;
            }
        }

        int[] semiNumArr = new int[N + 1];
        int semiNum = 0;

        for (int i = 1; i <= N; i++) {
            if (arr[i] != 0 && arr[i] != 1) {
                if (arr[i / arr[i]] == 1) {
                    semiNumArr[i] = ++semiNum;
                }
                semiNumArr[i] = semiNum;
            } else {
                semiNumArr[i] = semiNum;
            }
        }

        for (int i = 0; i < length; i++) {
            answer[i] = semiNumArr[Q[i]] - semiNumArr[P[i] - 1];
        }

        return answer;
    }

    private int getPrime(int[] primes, int N) {
        int count = 1;

        for (int i = 3; i <= N; i += 2) {
            int flag = 0;
            for (int j = 0; primes[j] * primes[j] <= i; j++) {
                if (i % primes[j] == 0) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                primes[count++] = i;
            }
        }

        return count;
    }
}
