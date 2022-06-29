//
// Hash Table, Prefix Sum, Array(Contiguous Array)
// https://leetcode.com/problems/contiguous-array/
// Created by hyungwook on 2022/06/23.
//

import java.util.HashMap;

public class Solution {

    public int findMaxLength(int[] nums) {
        int sum = 0;
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 1 ? 1 : -1;

            if (map.containsKey(sum)) {
                answer = Math.max(answer, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return answer;
    }
}