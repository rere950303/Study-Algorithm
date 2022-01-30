//
// 해쉬맵(주차 요금 계산)
// https://programmers.co.kr/learn/courses/30/lessons/92341?language=java
// Created by hyungwook on 2022/01/21.
//

import java.util.HashMap;

public class Solution {

    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> time = new HashMap<>();
        HashMap<String, Integer> record = new HashMap<>();

        for (String s : records) {
            String[] split = s.split(" ");

            if (split[2].equals("IN")) {
                record.put(split[1], getMin(split[0]));
            } else {
                Integer outTime = getMin(split[0]);
                Integer inTime = record.get(split[1]);
                time.put(split[1], time.getOrDefault(split[1], 0) + outTime - inTime);
                record.remove(split[1]);
            }
        }

        if (!record.isEmpty()) {
            for (String s : record.keySet()) {
                Integer inTime = record.get(s);
                time.put(s, time.getOrDefault(s, 0) + 1439 - inTime);
            }
        }

        HashMap<String, Integer> cost = new HashMap<>();

        for (String s : time.keySet()) {
            Integer integer = time.get(s);
            Integer perCost = getCost(integer, fees);
            cost.put(s, perCost);
        }

        return cost.entrySet().stream().sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey())).mapToInt(o -> o.getValue()).toArray();
    }

    private Integer getCost(Integer time, int[] fees) {
        if (time <= fees[0]) {
            return fees[1];
        } else {
            return fees[1] + (int) Math.ceil((double) (time - fees[0]) / fees[2]) * fees[3];
        }
    }

    private Integer getMin(String time) {
        String[] split = time.split(":");
        return Integer.valueOf(split[0]) * 60 + Integer.valueOf(split[1]);
    }
}