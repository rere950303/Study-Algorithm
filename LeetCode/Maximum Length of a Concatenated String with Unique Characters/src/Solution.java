//
// DFS, Backtracking, Bit Manipulation, Array(Maximum Length of a Concatenated String with Unique Characters)
// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
// Created by hyungwook on 2022/05/06.
//

import java.util.List;

public class Solution {

    int answer = Integer.MIN_VALUE;

    public int maxLength(List<String> arr) {
        dfs(arr, 0, 0);

        return answer;
    }

    private void dfs(List<String> arr, int l, int bitMask) {
        if (l == arr.size()) {
            answer = Math.max(answer, getLen(bitMask));
        } else {
            int newBitMask = getNewBitMask(arr.get(l), bitMask);

            if (newBitMask != bitMask) {
                dfs(arr, l + 1, newBitMask);
            }
            dfs(arr, l + 1, bitMask);
        }
    }

    private int getLen(int bitMask) {
        int count = 0;

        for (int i = 0; i < 26; i++) {
            if ((bitMask & 1 << i) != 0) {
                count++;
            }
        }

        return count;
    }

    private int getNewBitMask(String s, int bitMask) {
        int tmp = bitMask;

        for (char c : s.toCharArray()) {
            if ((bitMask & (1 << c - 'a')) != 0) {
                return tmp;
            } else {
                bitMask = (bitMask ^ (1 << c - 'a'));
            }
        }

        return bitMask;
    }
}