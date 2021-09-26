//
// Time Complexity(TapeEquilibrium)
//
// Created by hyungwook on 2021/09/27.
//

public class Solution {

    public int solution(int[] A) {
        int length = A.length;
        int totalSum = 0;
        for (int i : A) {
            totalSum += i;
        }
        int min = Integer.MAX_VALUE;
        int ltSum = 0;

        for (int i = 0; i < length - 1; i++) {
            ltSum += A[i];
            int rtSum = totalSum - ltSum;
            min = Math.min(min, Math.abs(ltSum - rtSum));
        }

        return min;
    }
}
