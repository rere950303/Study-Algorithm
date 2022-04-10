//
// Greedy, Array, Sorting(Find Original Array From Doubled Array)
// https://leetcode.com/problems/find-original-array-from-doubled-array/
// Created by hyungwook on 2022/04/01.
//

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[] findOriginalArray(int[] changed) {
        int[] nums = new int[100001];

        for (int v : changed) {
            nums[v]++;
        }
        List<Integer> answer = new ArrayList<>();

        if (nums[0] % 2 != 0) {
            return new int[]{};
        } else {
            addAnswer(nums[0] / 2, answer, 0);
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                int count = nums[i];
                nums[i] = 0;

                if (2 * i > 100000 || nums[2 * i] < count) {
                    return new int[]{};
                } else {
                    nums[2 * i] -= count;
                    addAnswer(count, answer, i);
                }
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private void addAnswer(int count, List<Integer> answer, int v) {
        for (int i = 0; i < count; i++) {
            answer.add(v);
        }
    }
}