//
// Bit Manipulation, Prefix Sum, String(Number of Wonderful Substrings)
// https://leetcode.com/problems/number-of-wonderful-substrings/
// Created by hyungwook on 2022/05/05.
//

public class Solution {

    public long wonderfulSubstrings(String word) {
        long answer = 0;
        long[] counts = new long[1024];
        counts[0] = 1;
        int bitMask = 0;

        for (char c : word.toCharArray()) {
            bitMask = bitMask ^ 1 << (c - 'a');
            answer += counts[bitMask];

            for (int i = 0; i < 10; i++) {
                answer += counts[bitMask ^ 1 << i];
            }
            counts[bitMask]++;
        }

        return answer;
    }
}