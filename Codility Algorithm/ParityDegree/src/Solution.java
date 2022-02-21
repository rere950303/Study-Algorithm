//
// Coding skills(ParityDegree)
// https://app.codility.com/programmers/trainings/5/parity_degree/
// Created by hyungwook on 2022/02/19.
//

public class Solution {

    public int solution(int N) {
        int answer = 0;
        int k = 1;
        double pow = 0;

        do {
            pow = Math.pow(2, k);
            double reg = N % pow;

            if (reg == 0) {
                answer = k;
            }
            k++;
        } while (pow <= N);

        return answer;
    }
}