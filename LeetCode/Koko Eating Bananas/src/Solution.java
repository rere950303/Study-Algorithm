//
// Binary Search, Array(Koko Eating Bananas)
// https://leetcode.com/problems/koko-eating-bananas/
// Created by hyungwook on 2022/05/22.
//

import java.util.Arrays;

public class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        int pl = 1;
        int pr = Arrays.stream(piles).max().getAsInt();

        while (pl < pr) {
            int mid = (pl + pr) / 2;

            if (!canEat(h, mid, piles)) {
                pl = mid + 1;
            } else {
                pr = mid;
            }
        }

        return pl;
    }

    private boolean canEat(int h, int k, int[] piles) {
        return h >= Arrays.stream(piles).map(pile -> (int) Math.ceil((double) pile / k)).sum();
    }
}