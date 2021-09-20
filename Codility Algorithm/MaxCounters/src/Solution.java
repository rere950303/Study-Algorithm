//
// Counting Elements(MaxCounters)
// https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
// Created by hyungwook on 2021/09/20.
//

public class Solution {
    int[] answer;
    int length;
    int max = 0;
    int lastMax = 0;

    public int[] solution(int N, int[] A) {
        answer = new int[N];
        length = A.length;

        for (int i = 0; i < length; i++) {
            if (A[i] == N + 1) {
                lastMax = max;
            } else {
                if (answer[A[i] - 1] < lastMax) {
                    answer[A[i] - 1] = lastMax + 1;
                } else {
                    answer[A[i] - 1]++;
                }

                max = Math.max(max, answer[A[i] - 1]);
            }
        }

        for (int i = 0; i < N; i++) {
            if (answer[i] < lastMax) {
                answer[i] = lastMax;
            }
        }

        return answer;
    }
}
