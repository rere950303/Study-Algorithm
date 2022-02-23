//
// Array, Two Pointers, Sorting(3Sum)
// https://leetcode.com/problems/3sum/
// Created by hyungwook on 2022/02/24.
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        Arrays.sort(nums);

        int length = nums.length;

        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int pl = i + 1;
            int pr = length - 1;

            while (pl < pr) {
                if (pr < length - 1 && nums[pr] == nums[pr + 1]) {
                    pr--;
                    continue;
                }
                int tmp = nums[i] + nums[pl] + nums[pr];

                if (tmp == 0) {
                    answer.add(new ArrayList<>(List.of(nums[i], nums[pl], nums[pr])));
                    pr--;
                } else if (tmp > 0) {
                    pr--;
                } else {
                    pl++;
                }
            }
        }

        return answer;
    }
}