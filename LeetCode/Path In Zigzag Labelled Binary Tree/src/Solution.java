//
// Math, Binary Tree(Path In Zigzag Labelled Binary Tree)
// https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/
// Created by hyungwook on 2022/03/20.
//

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> answer = new LinkedList<>();

        while (label > 0) {
            answer.addFirst(label);
            int exp = 0;

            while (Math.pow(2, exp + 1) <= label) {
                exp++;
            }
            int l = (int) Math.pow(2, exp);
            int r = (int) Math.pow(2, exp + 1) - 1;
            label = (l + r - label) / 2;
        }

        return answer;
    }
}