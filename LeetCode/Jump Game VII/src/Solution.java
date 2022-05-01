//
// Sliding Window, DP, Two Pointers(Jump Game VII)
// https://leetcode.com/problems/jump-game-vii/
// Created by hyungwook on 2022/04/12.
//

public class Solution {

    public boolean canReach(String s, int minJump, int maxJump) {
        boolean[] canReach = new boolean[s.length()];
        canReach[0] = true;
        int zeroNum = 0;

        for (int i = 1; i < s.length(); i++) {
            if (i - minJump >= 0 && canReach[i - minJump]) {
                zeroNum++;
            }
            if (s.charAt(i) == '0' && zeroNum > 0) {
                canReach[i] = true;
            }
            if (i - maxJump >= 0 && canReach[i - maxJump]) {
                zeroNum--;
            }
        }

        return canReach[s.length() - 1];
    }
}