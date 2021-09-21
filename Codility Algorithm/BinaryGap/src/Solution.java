//
// Iterations(BinaryGap)
// https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
// Created by hyungwook on 2021/09/21.
//

public class Solution {

    public int solution(int N) {
        int lastDigit = 0;
        int count = 0;
        int answer = 0;

        while (N > 0) {
            int rest = N % 2;
            if (rest == 1) {
                answer = Math.max(answer, count);
                count = 0;
                lastDigit = 1;
                N /= 2;
            } else {
                if (lastDigit == 1) {
                    count++;
                }
                N /= 2;
            }
        }

        return answer;
    }
}
