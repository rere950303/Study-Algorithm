//
// BFS, Graph(Keys and Rooms)
// https://leetcode.com/problems/keys-and-rooms/
// Created by hyungwook on 2022/06/29.
//

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] isVisit = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Integer roomNum = queue.poll();
                isVisit[roomNum] = true;
                List<Integer> keys = rooms.get(roomNum);

                for (Integer key : keys) {
                    if (!isVisit[key]) {
                        isVisit[key] = true;
                        queue.add(key);
                    }
                }
            }
        }

        for (boolean b : isVisit) {
            if (!b) {
                return false;
            }
        }

        return true;
    }
}