//
// Priority Queue, Sliding Window(Jump Game VI)
// https://leetcode.com/problems/jump-game-vi/
// Created by hyungwook on 2022/04/12.
//

import java.util.PriorityQueue;

public class Solution {

    public int maxResult(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((i1, i2) -> Integer.compare(i2[1], i1[1]));
        queue.add(new int[]{0, nums[0]});

        for (int i = 1; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.peek()[0] < i - k) {
                queue.poll();
            }
            nums[i] += queue.peek()[1];
            queue.add(new int[]{i, nums[i]});
        }

        return nums[nums.length - 1];
    }
}