//
// DFS(호텔 방 배정)
// https://programmers.co.kr/learn/courses/30/lessons/64063
// Created by hyungwook on 2022/02/26.
//

import java.util.HashMap;

public class Solution {

    HashMap<Long, Long> map = new HashMap<>();

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        for (int i = 0; i < room_number.length; i++) {
            answer[i] = getRoomNum(room_number[i]);
        }

        return answer;
    }

    private long getRoomNum(long roomNum) {
        if (!map.containsKey(roomNum)) {
            map.put(roomNum, roomNum + 1);
            return roomNum;
        }

        long emptyRoom = getRoomNum(map.get(roomNum));
        map.put(roomNum, map.get(emptyRoom));

        return emptyRoom;
    }
}