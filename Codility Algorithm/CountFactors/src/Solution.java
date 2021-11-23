//
// Prime and composite numbers(CountFactors)
// https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/count_factors/
// Created by hyungwook on 2021/11/18.
//

public class Solution {

    public int solution(int N) {
        int answer = 0;
        long i = 1;

        for (; i * i < N; i++) {
            if (N % i == 0) {
                answer++;
            }
        }

        if (i * i == N) {
            answer = answer * 2 + 1;
        } else {
            answer *= 2;
        }

        return answer;
    }
}