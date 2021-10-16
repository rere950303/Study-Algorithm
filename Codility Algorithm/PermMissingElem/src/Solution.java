//
// Time Complexity(PermMissingElem)
// https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
// Created by hyungwook on 2021/09/26.
//

public class Solution {

    public int solution(int[] A) {
        int length = A.length;
        boolean[] check = new boolean[length + 2];

        for (int i : A) {
            check[i] = true;
        }

        for (int i = 1; i <= length + 1; i++) {
            if (check[i] == false) {
                return i;
            }
        }

        return 0;
    }
}
