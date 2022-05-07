//
// Hash Table, Prefix Sum, Array(K Divisible Elements Subarrays)
// https://leetcode.com/problems/k-divisible-elements-subarrays/
// Created by hyungwook on 2022/05/07.
//

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {

    public int countDistinct(int[] nums, int k, int p) {
        int[] counts = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            counts[i + 1] = nums[i] % p == 0 ? counts[i] + 1 : counts[i];
        }
        HashSet<List<Integer>> set = new HashSet<>();

        for (int i = 1; i <= nums.length; i++) {
            List<Integer> list = new ArrayList<>();

            for (int j = i - 1; j >= 0; j--) {
                if (counts[i] - counts[j] > k) {
                    break;
                }
                list.add(nums[j]);
                set.add(new ArrayList<>(list));
            }
        }

        return set.size();
    }
}