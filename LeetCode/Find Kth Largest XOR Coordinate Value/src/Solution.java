//
// DP, Bit Manipulation, Matrix, Prefix Sum(Find Kth Largest XOR Coordinate Value)
// https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/
// Created by hyungwook on 2022/04/10.
//

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int target = matrix[i][j];

                if (i - 1 >= 0 && j - 1 >= 0) {
                    target ^= matrix[i - 1][j - 1] ^ matrix[i - 1][j] ^ matrix[i][j - 1];
                } else if (i - 1 >= 0) {
                    target ^= matrix[i - 1][j];
                } else if (j - 1 >= 0) {
                    target ^= matrix[i][j - 1];
                }
                matrix[i][j] = target;
                answer.add(target);
            }
        }

        Collections.sort(answer);
        return answer.get(answer.size() - k);
    }
}