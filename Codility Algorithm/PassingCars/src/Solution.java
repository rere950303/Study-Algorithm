//
// Prefix Sums(PassingCars)
//
// Created by hyungwook on 2021/09/29.
//

public class Solution {

    public int solution(int[] A) {
        int length = A.length;
        long answer = 0;
        int countZero = 0;

        for (int i = 0; i < length; i++) {
            if (A[i] == 1) {
                answer += countZero;
            } else {
                countZero++;
            }
        }

        if (answer > 1000000000) {
            answer = -1;
        }

        return (int) answer;
    }
}
