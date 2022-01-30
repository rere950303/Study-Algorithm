//
// Caterpillar method(CountDistinctSlices)
// https://app.codility.com/programmers/lessons/15-caterpillar_method/count_distinct_slices/
// Created by hyungwook on 2022/01/27.
//

public class Solution {

    public int solution(int M, int[] A) {
        int length = A.length;
        boolean[] check = new boolean[M + 1];
        int answer = 0;
        int pr = 0;

        for (int pl = 0; pl < length; pl++) {
            while (pr < length && !check[A[pr]]) {
                check[A[pr]] = true;
                answer += (pr - pl + 1);
                pr++;
                if (answer > 1000000000) {
                    return 1000000000;
                }
            }
            if (pr >= length) {
                return answer;
            }
            check[A[pl]] = false;
        }

        return answer;
    }
}
