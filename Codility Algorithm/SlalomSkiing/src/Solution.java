//
// 2015 Contest(SlalomSkiing)
// https://app.codility.com/programmers/trainings/1/slalom_skiing/
// Created by hyungwook on 2022/02/16.
//

import java.util.Arrays;

public class Solution {

    public int solution(int[] A) {
        long bound = Arrays.stream(A).max().getAsInt();
        long[] withMirrors = new long[A.length * 3];

        for (int i = 0; i < A.length; i++) {
            withMirrors[i * 3] = bound * 2 + A[i];
            withMirrors[i * 3 + 1] = bound * 2 - A[i] + 1;
            withMirrors[i * 3 + 2] = A[i];
        }

        long[] temp = new long[withMirrors.length];
        int idx = 0;

        for (int i = 0; i < withMirrors.length; i++) {
            int fnd = Arrays.binarySearch(temp, 0, idx, withMirrors[i]);

            if (fnd < 0) {
                fnd = -fnd - 1;
            }

            if (fnd == idx) {
                idx++;
            }

            temp[fnd] = withMirrors[i];
        }

        return idx;
    }
}