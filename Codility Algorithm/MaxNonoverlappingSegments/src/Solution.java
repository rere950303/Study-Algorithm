//
// Greedy algorithms(MaxNonoverlappingSegments)
// https://app.codility.com/programmers/lessons/16-greedy_algorithms/max_nonoverlapping_segments/
// Created by hyungwook on 2022/01/30.
//

public class Solution {

    public int solution(int[] A, int[] B) {
        int answer = 0;
        int length = A.length;
        int endTime = -1;

        for (int i = 0; i < length; i++) {
            if (endTime < A[i]) {
                endTime = B[i];
                answer++;
            }
        }

        return answer;
    }
}
