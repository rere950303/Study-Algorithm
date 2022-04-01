//
// Binary Search, Matrix(Kth Smallest Element in a Sorted Matrix)
// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
// Created by hyungwook on 2022/03/27.
//

public class Solution {

    public int kthSmallest(int[][] matrix, int k) {
        int length = matrix.length;
        int min = matrix[0][0];
        int max = matrix[length - 1][length - 1];
        int answer = Integer.MAX_VALUE;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (count(matrix, mid) >= k) {
                answer = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return answer;
    }

    private int count(int[][] matrix, int mid) {
        int count = 0;
        int r = 0;
        int c = matrix.length - 1;

        while (r < matrix.length && c >= 0) {
            if (matrix[r][c] <= mid) {
                count += c + 1;
                r++;
            } else {
                c--;
            }
        }

        return count;
    }
}