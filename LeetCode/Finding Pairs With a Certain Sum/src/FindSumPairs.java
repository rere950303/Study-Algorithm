//
// Hash Table, Design, Array(Finding Pairs With a Certain Sum)
// https://leetcode.com/problems/finding-pairs-with-a-certain-sum/
// Created by hyungwook on 2022/03/25.
//

import java.util.HashMap;

class FindSumPairs {

    private final int[] nums2;
    private final HashMap<Integer, Integer> nums1Map = new HashMap<>();
    private final HashMap<Integer, Integer> nums2Map = new HashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums2 = nums2;
        numsMap(nums1, nums1Map);
        numsMap(nums2, nums2Map);
    }

    private void numsMap(int[] nums, HashMap<Integer, Integer> numsMap) {
        for (int num : nums) {
            numsMap.put(num, numsMap.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int tmp = nums2[index];
        nums2[index] += val;

        nums2Map.put(tmp, nums2Map.get(tmp) - 1);
        if (nums2Map.get(tmp) == 0) {
            nums2Map.remove(tmp);
        }
        nums2Map.put(tmp + val, nums2Map.getOrDefault(tmp + val, 0) + 1);
    }

    public int count(int tot) {
        int count = 0;

        for (Integer key : nums1Map.keySet()) {
            if (nums2Map.containsKey(tot - key)) {
                count += nums1Map.get(key) * nums2Map.get(tot - key);
            }
        }

        return count;
    }
}