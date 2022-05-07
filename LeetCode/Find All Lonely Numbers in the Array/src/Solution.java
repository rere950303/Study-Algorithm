//
// Hash Table, Counting, Array(Find All Lonely Numbers in the Array)
// https://leetcode.com/problems/find-all-lonely-numbers-in-the-array/
// Created by hyungwook on 2022/05/05.
//

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public List<Integer> findLonely(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (map.get(num) == 1 && !map.containsKey(num - 1) && !map.containsKey(num + 1)) {
                answer.add(num);
            }
        }

        return answer;
    }
}