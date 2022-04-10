//
// Hash Table, Array, Greedy, Math(Make Sum Divisible by P)
// https://leetcode.com/problems/make-sum-divisible-by-p/
// Created by hyungwook on 2022/04/02.
//

import java.util.HashMap;

class Solution {
    public int minSubarray(int[] nums, int p) {
        int sum = 0;

        for (int num : nums) {
            sum = (num + sum) % p;
        }
        int remainder = sum % p;

        if (remainder == 0) {
            return 0;
        }
        HashMap<Integer, Integer> remainderIdxMap = new HashMap<>();
        remainderIdxMap.put(0, -1);
        int currRemainder = 0;
        int answer = nums.length;

        for (int i = 0; i < nums.length; i++) {
            currRemainder = (currRemainder + nums[i]) % p;
            int searchFor = (currRemainder - remainder);

            if (searchFor < 0) {
                searchFor += p;
            }
            if (remainderIdxMap.containsKey(searchFor)) {
                answer = Math.min(answer, i - remainderIdxMap.get(searchFor));
            }
            remainderIdxMap.put(currRemainder, i);
        }

        return answer == nums.length ? -1 : answer;
    }
}