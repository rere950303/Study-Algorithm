//
// Segment Tree, Array, Design(Range Sum Query - Mutable)
// https://leetcode.com/problems/range-sum-query-mutable/
// Created by hyungwook on 2022/03/17.
//

public class NumArray {

    /**
        특정 range가 주어지는 문제의 경우 Prefix Sum 또는 Segment Tree를 생각해볼 수 있다.
        가변적인 range를 다루는 문제의 경우 Two Pointer를 생각해볼 수 있다.
     **/

    private int[] seg;
    private int length;

    public NumArray(int[] nums) {
        length = nums.length;
        seg = new int[length * 4];
        makeSegmentTree(nums, 1, 0, length - 1);
    }

    private void makeSegmentTree(int[] nums, int idx, int pl, int pr) {
        if (pl == pr) {
            seg[idx] = nums[pl];
            return;
        }
        int mid = (pl + pr) / 2;
        makeSegmentTree(nums, idx * 2, pl, mid);
        makeSegmentTree(nums, idx * 2 + 1, mid + 1, pr);

        seg[idx] = seg[idx * 2] + seg[idx * 2 + 1];
    }

    public void update(int index, int val) {
        updateHelper(1, 0, length - 1, index, val);
    }

    private void updateHelper(int idx, int pl, int pr, int index, int val) {
        if (pl == pr) {
            seg[idx] = val;
            return;
        }
        int mid = (pl + pr) / 2;

        if (mid >= index) {
            updateHelper(idx * 2, pl, mid, index, val);
        } else {
            updateHelper(idx * 2 + 1, mid + 1, pr, index, val);
        }

        seg[idx] = seg[idx * 2] + seg[idx * 2 + 1];
    }

    public int sumRange(int left, int right) {
        return sumRangeHelper(1, 0, length - 1, left, right);
    }

    private int sumRangeHelper(int idx, int pl, int pr, int left, int right) {
        if (pr < left || pl > right) {
            return 0;
        }
        if (pl >= left && pr <= right) {
            return seg[idx];
        }
        int mid = (pl + pr) / 2;
        int l = sumRangeHelper(idx * 2, pl, mid, left, right);
        int r = sumRangeHelper(idx * 2 + 1, mid + 1, pr, left, right);

        return l + r;
    }
}