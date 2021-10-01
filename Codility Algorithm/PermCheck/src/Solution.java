//
// Counting Elements(PermCheck)
//
// Created by hyungwook on 2021/09/28.
//

public class Solution {

    public int solution(int[] A) {
        int length = A.length;
        boolean[] check = new boolean[length + 1];
        int count = 0;

        for (int i = 0; i < length; i++) {
            if (A[i] <= length && check[A[i]] == false) {
                check[A[i]] = true;
                count++;
            }
        }

        if (count == length) {
            return 1;
        } else {
            return 0;
        }
    }
}
