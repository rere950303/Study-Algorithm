//
// sorting(MaxProductOfThree)
// https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/
// Created by hyungwook on 2021/10/27.
//

import java.util.Arrays;

public class Solution {

    public int solution(int[] A) {
        Arrays.sort(A);
        int length = A.length;

        return Math.max(A[length - 1] * A[length - 2] * A[length - 3], A[0] * A[1] * A[length - 1]);
    }
}
