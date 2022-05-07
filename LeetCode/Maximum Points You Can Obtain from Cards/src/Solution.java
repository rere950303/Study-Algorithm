//
// Sliding Window, Prefix Sum, Array(Maximum Points You Can Obtain from Cards)
// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
// Created by hyungwook on 2022/05/03.
//

import java.util.Arrays;

public class Solution {

    public int maxScore(int[] cardPoints, int k) {
        int sum;
        int answer;

        answer = sum = Arrays.stream(cardPoints, 0, k).sum();
        for (int i = 0; i < k; i++) {
            sum = sum - cardPoints[k - 1 - i] + cardPoints[cardPoints.length - 1 - i];
            answer = Math.max(answer, sum);
        }

        return answer;
    }
}