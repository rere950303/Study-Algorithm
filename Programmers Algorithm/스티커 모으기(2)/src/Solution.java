//
// DP(스티커 모으기(2))
// https://programmers.co.kr/learn/courses/30/lessons/12971?language=java
// Created by hyungwook on 2022/02/14.
//

public class Solution {

    public int solution(int sticker[]) {
        int length = sticker.length;

        if (length == 1) {
            return sticker[0];
        }
        if (length == 2) {
            return Math.max(sticker[0], sticker[1]);
        }

        int answer = Integer.MIN_VALUE;
        int[] firstNoCheckDp = new int[length];

        firstNoCheckDp[0] = 0;
        firstNoCheckDp[1] = sticker[1];

        for (int i = 2; i < length; i++) {
            firstNoCheckDp[i] = Math.max(firstNoCheckDp[i - 1], firstNoCheckDp[i - 2] + sticker[i]);
        }

        answer = Math.max(answer, firstNoCheckDp[length - 1]);

        int[] firstCheckDp = new int[length - 1];

        firstCheckDp[0] = sticker[0];
        firstCheckDp[1] = sticker[0];

        for (int i = 2; i < length - 1; i++) {
            firstCheckDp[i] = Math.max(firstCheckDp[i - 1], firstCheckDp[i - 2] + sticker[i]);
        }

        answer = Math.max(answer, firstCheckDp[length - 2]);

        return answer;
    }
}