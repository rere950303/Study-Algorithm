//
// Two Pointers, Array, Greedy(Maximum Distance Between a Pair of Values)
// https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/
// Created by hyungwook on 2022/03/04.
//

public class Solution {

    public int maxDistance(int[] nums1, int[] nums2) {
        int idx1 = 0;
        int idx2 = 0;
        int answer = 0;

        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] <= nums2[idx2]) {
                answer = Math.max(answer, idx2 - idx1);
                idx2++;
            } else {
                idx1++;
            }
        }

        return answer;
    }
}