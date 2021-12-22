//
// 이분 탐색(징검다리 건너기)
// https://programmers.co.kr/learn/courses/30/lessons/64062
// Created by hyungwook on 2021/12/06.
//

public class Solution {

    public int solution(int[] stones, int k) {
        int pr = Integer.MIN_VALUE;
        int pl = Integer.MAX_VALUE;
        int answer = 0;

        for (int stone : stones) {
            pr = Math.max(pr, stone);
            pl = Math.min(pl, stone);
        }

        while (pl <= pr) {
            int pc = (pl + pr) / 2;

            if (canCross(pc, stones, k)) {
                answer = pc;
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }
        }

        return answer;
    }

    private boolean canCross(int num, int[] stones, int maxJump) {
        int tmp = 0;

        for (int stone : stones) {
            if (num > stone) {
                tmp++;
            } else {
                tmp = 0;
            }

            if (tmp == maxJump) {
                return false;
            }
        }

        return true;
    }
}
