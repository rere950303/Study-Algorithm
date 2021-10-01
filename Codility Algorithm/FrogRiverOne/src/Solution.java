//
// Counting Elements(FrogRiverOne)
//
// Created by hyungwook on 2021/09/27.
//

public class Solution {

    public int solution(int X, int[] A) {
        boolean[] check = new boolean[X + 1];
        int length = A.length;
        int answer = -1;
        int count = 0;

        for (int i = 0; i < length; i++) {
            if (check[A[i]] == false) {
                check[A[i]] = true;
                count++;
                if (count == X) {
                    answer = i;
                    break;
                }
            }
        }

        return answer;
    }
}