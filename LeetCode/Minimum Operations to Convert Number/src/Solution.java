//
// BFS, Array(Minimum Operations to Convert Number)
// https://leetcode.com/problems/minimum-operations-to-convert-number/
// Created by hyungwook on 2022/03/01.
//

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        queue.add(start);
        int l = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();

                if (poll == goal) {
                    return l;
                }
                if (poll >= 0 && poll <= 1000 && !set.contains(poll)) {
                    set.add(poll);
                    for (int num : nums) {
                        int tmp1 = poll + num;
                        int tmp2 = poll - num;
                        int tmp3 = poll ^ num;

                        if (tmp1 == goal || tmp2 == goal || tmp3 == goal) {
                            return l + 1;
                        }
                        queue.add(tmp1);
                        queue.add(tmp2);
                        queue.add(tmp3);
                    }
                }
            }

            l++;
        }

        return -1;
    }
}