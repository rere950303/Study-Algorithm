//
// Data Structures(ArrListLen)
// https://app.codility.com/programmers/trainings/7/arr_list_len/
// Created by hyungwook on 2022/02/19.
//

public class Solution {

    public int solution(int[] A) {
        int answer = 0;
        int idx = 0;

        do {
            idx = A[idx];
            answer++;
        } while (idx != -1);

        return answer;
    }
}