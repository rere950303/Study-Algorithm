//
// Counting Elements(MissingInteger)
//
// Created by hyungwook on 2021/09/29.
//

import java.util.Arrays;

public class Solution {

    public int solution(int[] A) {
        int answer = 1;
        Arrays.sort(A);

        for (int i : A) {
            if (i == answer) {
                answer++;
            }
        }

        return answer;
    }
}
