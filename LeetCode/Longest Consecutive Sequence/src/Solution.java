//
// Hash Table, Union Find, Array(Longest Consecutive Sequence)
// https://leetcode.com/problems/longest-consecutive-sequence/
// Created by hyungwook on 2022/06/02.
//

import java.util.HashSet;

public class Solution {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        int answer = 0;

        for (Integer start : set) {
            if (!set.contains(start - 1)) {
                int len = 1;

                while (set.contains(start + 1)) {
                    start++;
                    len++;
                }
                answer = Math.max(answer, len);
            }
        }

        return answer;
    }
}