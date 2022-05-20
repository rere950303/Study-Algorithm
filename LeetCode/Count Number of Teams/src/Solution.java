//
// DP(Count Number of Teams)
// https://leetcode.com/problems/count-number-of-teams/
// Created by hyungwook on 2022/05/13.
//

public class Solution {

    public int numTeams(int[] rating) {
        int answer = 0;

        for (int i = 1; i < rating.length - 1; i++) {
            int num = rating[i];
            int leftUp = 0;
            int leftDown = 0;
            int rightUp = 0;
            int rightDown = 0;

            for (int j = i - 1; j >= 0; j--) {
                if (num > rating[j]) {
                    leftDown++;
                } else {
                    leftUp++;
                }
            }
            for (int j = i + 1; j < rating.length; j++) {
                if (num > rating[j]) {
                    rightDown++;
                } else {
                    rightUp++;
                }
            }

            answer += leftDown * rightUp + leftUp * rightDown;
        }

        return answer;
    }
}
