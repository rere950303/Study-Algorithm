//
// Array, Heap, Ordered Set(Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit)
// https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
// Created by hyungwook on 2022/03/03.
//

class Solution {

    public int longestSubarray(int[] nums, int limit) {
        int len = nums.length;
        int[] dec = new int[len];
        int[] inc = new int[len];

        int s1 = 0;
        int maxIndex = 0;
        int s2 = 0;
        int minIndex = 0;
        int pl = 0;
        int pr = 0;

        for (; pr < len; pr++) {
            int n = nums[pr];

            while(maxIndex > s1 && dec[maxIndex - 1] < n) {
                maxIndex--;
            }
            dec[maxIndex++] = n;

            while(minIndex > s2 && inc[minIndex - 1] > n) {
                minIndex--;
            }
            inc[minIndex++] = n;

            if (dec[s1] - inc[s2] > limit) {
                int m = nums[pl++];

                if (dec[s1] == m) {
                    s1++;
                }
                if (inc[s2] == m) {
                    s2++;
                }
            }
        }

        return pr - pl;
    }
}