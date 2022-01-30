//
// Fibonacci numbers(Ladder)
// https://app.codility.com/programmers/lessons/13-fibonacci_numbers/ladder/
// Created by hyungwook on 2022/01/26.
//

public class Solution {

    public int[] solution(int[] A, int[] B) {
        int max = (int) Math.pow(2, 30);
        int[] fibonacci = new int[50000];
        fibonacci[0] = 1;
        fibonacci[1] = 2;
        int length = A.length;
        int[] answer = new int[length];

        for (int i = 2; i < length; i++) {
            fibonacci[i] = (fibonacci[i - 1] + fibonacci[i - 2]) % max;
        }

        for (int i = 0; i < length; i++) {
            answer[i] = (int) (fibonacci[A[i] - 1] % Math.pow(2, B[i]));
        }

        return answer;
    }
}