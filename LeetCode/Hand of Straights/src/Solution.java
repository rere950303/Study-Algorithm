//
// Array, Hash Table, Greedy, Sorting(Hand of Straights)
// https://leetcode.com/problems/hand-of-straights/
// Created by hyungwook on 2022/03/01.
//

import java.util.Arrays;

public class Solution {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (groupSize == 1) {
            return true;
        }
        Arrays.sort(hand);
        int pl = 0;
        int pr = 0;
        boolean[] check = new boolean[hand.length];
        check[0] = true;
        int tmp = 1;

        while (pr < hand.length) {
            check[pl] = true;
            int start = hand[pl];
            tmp = 1;

            while (pr < hand.length) {
                if (check[pr] || hand[pr] == start) {
                    pr++;
                } else {
                    if (hand[pr] == start + 1) {
                        check[pr] = true;
                        tmp++;
                        start++;
                        pr++;
                        if (tmp == groupSize) {
                            break;
                        }
                    } else {
                        return false;
                    }
                }
            }

            while (pl < hand.length) {
                if (check[pl]) {
                    pl++;
                } else {
                    break;
                }
            }

            pr = pl;
        }

        return tmp == groupSize ? true : false;
    }
}