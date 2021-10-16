//
// Time Complexity(FrogJmp)
// https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
// Created by hyungwook on 2021/09/26.
//

public class Solution {

    public int solution(int X, int Y, int D) {
        int interval = Y - X;
        int remainder = interval % D;

        if (remainder == 0) {
            return interval / D;
        } else {
            return interval / D + 1;
        }
    }
}
