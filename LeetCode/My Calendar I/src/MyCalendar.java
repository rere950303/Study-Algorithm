//
// Tree Map, Segment Tree, Design(My Calendar I)
// https://leetcode.com/problems/my-calendar-i/
// Created by hyungwook on 2022/05/16.
//

import java.util.TreeMap;

class MyCalendar {

    TreeMap<Integer, Integer> map;

    public MyCalendar() {
        this.map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer higherKey = map.ceilingKey(start);
        Integer lowerKey = map.floorKey(start);

        if ((higherKey == null || higherKey >= end) && (lowerKey == null || map.get(lowerKey) <= start)) {
            map.put(start, end);
            return true;
        }

        return false;
    }
}