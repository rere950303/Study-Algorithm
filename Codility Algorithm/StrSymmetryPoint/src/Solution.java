//
// Algorithmic skills(StrSymmetryPoint)
// https://app.codility.com/programmers/trainings/4/str_symmetry_point/
// Created by hyungwook on 2022/02/18.
//

public class Solution {

    public int solution(String S) {
        int length = S.length();

        if (length % 2 == 0) {
            return -1;
        }

        int mid = length / 2;

        String substring = S.substring(0, mid);
        String reverse = new StringBuilder(S.substring(mid + 1, length)).reverse().toString();

        if (reverse.equals(substring)) {
            return mid;
        } else {
            return -1;
        }
    }
}