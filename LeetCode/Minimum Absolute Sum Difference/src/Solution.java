//
// Binary Search, Ordered Set, Sorting(Minimum Absolute Sum Difference)
// https://leetcode.com/problems/minimum-absolute-sum-difference/
// Created by hyungwook on 2022/06/22.
//

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Solution {

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int length = nums1.length;
        int answer = 0;
        int reduce = 0;
        int modular = (int) (Math.pow(10, 9) + 7);
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.stream(nums1).boxed().collect(Collectors.toSet()));

        for (int i = 0; i < length; i++) {
            int sub = Math.abs(nums1[i] - nums2[i]);
            answer = (answer + sub) % modular;
            Integer high = treeSet.ceiling(nums2[i]);
            Integer low = treeSet.floor(nums2[i]);

            if (high != null) {
                reduce = Math.max(reduce, sub - (high - nums2[i]));
            }
            if (low != null) {
                reduce = Math.max(reduce, sub - (nums2[i] - low));
            }
        }

        return (answer - reduce + modular) % modular;
    }
}