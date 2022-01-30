//
// Caterpillar method(CountTriangles)
// https://app.codility.com/programmers/lessons/15-caterpillar_method/count_triangles/
// Created by hyungwook on 2022/01/29.
//

import java.util.Arrays;

public class Solution {

    public int solution(int[] A) {
        int length = A.length;
        int answer = 0;
        Arrays.sort(A);

        for (int pl = 0; pl < length - 2; pl++) {
            int pr1 = pl + 1;
            int pr2 = pr1 + 1;

            while (pr1 < length - 1) {
                if (pr2 < length && A[pl] + A[pr1] > A[pr2]) {
                    pr2++;
                } else {
                    answer += pr2 - pr1 - 1;
                    pr1++;
                }
            }
        }

        return answer;
    }
}
