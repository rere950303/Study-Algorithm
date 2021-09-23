//
// Arrays(CyclicRotation)
// https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
// Created by hyungwook on 2021/09/23.
//

public class Solution {
    public int[] solution(int[] A, int K) {
        int length = A.length;
        int[] answer = new int[length];

        for (int i = 0; i < length; i++) {
            answer[(i + K) % length] = A[i];
        }

        return answer;
    }
}
