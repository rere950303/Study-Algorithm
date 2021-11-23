//
// 규칙 찾기(셔틀버스)
// https://programmers.co.kr/learn/courses/30/lessons/17678
// Created by hyungwook on 2021/11/20.
//

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {

    public String solution(int n, int t, int m, String[] timetable) {
        int answer = 0;
        PriorityQueue<Integer> arriveTime = new PriorityQueue<>();

        for (String s : timetable) {
            String[] split = s.split(":");
            arriveTime.add(Integer.valueOf(split[0]) * 60 + Integer.valueOf(split[1]));
        }

        ArrayList<Integer> busTime = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            busTime.add(540 + t * i);
        }

        for (Integer integer : busTime) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                if (arriveTime.isEmpty()) {
                    break;
                }
                if (arriveTime.peek() <= integer) {
                    tmp.add(arriveTime.poll());
                } else {
                    break;
                }
            }
            if (tmp.size() != m) {
                answer = integer;
            } else {
                answer = tmp.get(m - 1) - 1;
            }
        }

        return String.format("%02d:%02d", answer / 60, answer % 60);
    }
}