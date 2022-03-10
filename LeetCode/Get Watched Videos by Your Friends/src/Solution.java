//
// Hash Table, BFS, Sorting(Get Watched Videos by Your Friends)
// https://leetcode.com/problems/get-watched-videos-by-your-friends/
// Created by hyungwook on 2022/03/10.
//

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        boolean[] check = new boolean[friends.length];
        int l = 0;
        Queue<Integer> queue = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();

        queue.add(id);
        check[id] = true;

        while (!queue.isEmpty() && l <= level) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();

                if (l == level) {
                    for (String video : watchedVideos.get(poll)) {
                        map.put(video, map.getOrDefault(video, 0) + 1);
                    }
                } else {
                    for (int friend : friends[poll]) {
                        if (!check[friend]) {
                            check[friend] = true;
                            queue.add(friend);
                        }
                    }
                }
            }

            l++;
        }

        List<String> answer = map.entrySet().stream().sorted((o1, o2) -> {return o1.getValue() != o2.getValue() ?
                o1.getValue() - o2.getValue() : o1.getKey().compareTo(o2.getKey());
        }).map((e) -> e.getKey()).collect(Collectors.toList());

        return answer;
    }
}