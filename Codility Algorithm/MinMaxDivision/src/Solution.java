//
// Binary search algorithm(MinMaxDivision)
// https://app.codility.com/programmers/lessons/14-binary_search_algorithm/min_max_division/
// Created by hyungwook on 2022/01/26.
//

public class Solution {

    int length;

    public int solution(int K, int M, int[] A) {
        length = A.length;
        int sum = 0;
        int answer = 0;

        for (int i = 0; i < length; i++) {
            sum += A[i];
        }

        int pl = (int) Math.ceil((double) sum / (double) K);
        int pr = sum;

        while (pl <= pr) {
            int pc = (pl + pr) / 2;

            if (canDivide(K, pc, A)) {
                answer = pc;
                pr = pc - 1;
            } else {
                pl = pc + 1;
            }
        }

        return answer;
    }

    private boolean canDivide(int K, int pc, int[] A) {
        int count = 0;
        int tmp = 0;
        int idx = 0;

        while (idx < length) {
            int sum = tmp + A[idx];

            if (sum < pc) {
                tmp = sum;
                idx++;
                continue;
            }
            if (sum == pc) {
                count++;
                tmp = 0;
                idx++;
            } else {
                if (tmp == 0) {
                    return false;
                } else {
                    count++;
                    tmp = 0;
                }
            }
        }

        if (tmp != 0) {
            count++;
        }

        return count <= K ? true : false;
    }
}
