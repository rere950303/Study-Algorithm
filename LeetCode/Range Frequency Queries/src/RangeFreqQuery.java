//
// Segment Tree, Binary Search, Hash Table, Design, Array(Range Frequency Queries)
// https://leetcode.com/problems/range-frequency-queries/
// Created by hyungwook on 2022/05/21.
//

import java.util.HashMap;

public class RangeFreqQuery {

    private HashMap<Integer, HashMap<Integer, Integer>> map;
    private int len;

    public RangeFreqQuery(int[] arr) {
        this.len = arr.length;
        this.map = new HashMap<>();
        makeSegmentTree(arr, 1, 0, len - 1);
    }

    private void makeSegmentTree(int[] arr, int idx, int pl, int pr) {
        if (pl == pr) {
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(arr[pl], 1);
            this.map.put(idx, map);
            return;
        }
        int mid = (pl + pr) / 2;
        makeSegmentTree(arr, idx * 2, pl, mid);
        makeSegmentTree(arr, idx * 2 + 1, mid + 1, pr);

        HashMap<Integer, Integer> lMap = map.get(idx * 2);
        HashMap<Integer, Integer> rMap = map.get(idx * 2 + 1);
        HashMap<Integer, Integer> map = new HashMap<>();

        lMap.forEach((k, v) -> map.merge(k, v, (v1, v2) -> v1 + v2));
        rMap.forEach((k, v) -> map.merge(k, v, (v1, v2) -> v1 + v2));

        this.map.put(idx, map);
    }

    public int query(int left, int right, int value) {
        return queryHelper(1, 0, len - 1, left, right, value);
    }

    private int queryHelper(int idx, int pl, int pr, int left, int right, int value) {
        if (pr < left || pl > right) {
            return 0;
        }
        if (pr <= right && pl >= left) {
            return map.get(idx).containsKey(value) ? map.get(idx).get(value) : 0;
        }
        int mid = (pl + pr) / 2;

        return queryHelper(idx * 2, pl, mid, left, right, value) + queryHelper(idx * 2 + 1, mid + 1, pr, left, right, value);
    }
}