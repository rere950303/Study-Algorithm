//
// Prime and composite numbers(MinPerimeterRectangle)
// https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/min_perimeter_rectangle/
// Created by hyungwook on 2021/11/19.
//

public class Solution {

    public int solution(int N) {
        int answer = Integer.MAX_VALUE;

        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                answer = Math.min(answer, 2 * (i + (N / i)));
            }
        }

        return answer;
    }
}
