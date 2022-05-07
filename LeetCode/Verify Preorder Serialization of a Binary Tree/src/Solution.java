//
// Binary Tree, String(Verify Preorder Serialization of a Binary Tree)
// https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
// Created by hyungwook on 2022/05/05.
//

public class Solution {

    public boolean isValidSerialization(String preorder) {
        if (preorder.equals("#")) {
            return true;
        }
        String[] splits = preorder.split(",");
        int sentinelCount = 0;

        for (int i = 0; i < splits.length; i++) {
            String split = splits[i];

            if (split.equals("#")) {
                sentinelCount--;
                if (sentinelCount < 0 || sentinelCount == 0 && i != splits.length - 1) {
                    return false;
                }
            } else {
                if (i == 0) {
                    sentinelCount += 2;
                } else {
                    sentinelCount += 1;
                }
            }
        }

        return sentinelCount == 0;
    }
}