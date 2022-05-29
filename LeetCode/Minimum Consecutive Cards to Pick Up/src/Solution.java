//
// Hash Table, Sliding Window, Array(Minimum Consecutive Cards to Pick Up)
// https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/
// Created by hyungwook on 2022/05/27.
//

import java.util.HashMap;

public class Solution {

    public int minimumCardPickup(int[] cards) {
        int answer = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < cards.length; i++) {
            if (map.containsKey(cards[i])) {
                answer = Math.min(answer, i - map.get(cards[i]));
            }
            map.put(cards[i], i);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer + 1;
    }
}