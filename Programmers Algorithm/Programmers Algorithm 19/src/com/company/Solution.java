package com.company;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        HashSet<Integer> reserveMan = new HashSet<>();
        Arrays.sort(reserve);
        Arrays.sort(lost);

        for (int i : lost) {
            if (Arrays.binarySearch(reserve, i) >= 0) {
                reserveMan.add(reserve[Arrays.binarySearch(reserve, i)]);
                continue;
            }if (Arrays.binarySearch(reserve, i - 1) >= 0 && Arrays.binarySearch(lost, i - 1) < 0) {
                reserveMan.add(reserve[Arrays.binarySearch(reserve, i - 1)]);
                if (Arrays.binarySearch(lost, i - 2) < 0 || Arrays.binarySearch(reserve, i - 2) >= 0) {
                    continue;
                }
            }if (Arrays.binarySearch(reserve, i + 1) >= 0 && Arrays.binarySearch(lost, i + 1) < 0) {
                reserveMan.add(reserve[Arrays.binarySearch(reserve, i + 1)]);
            }
        }

        if (reserveMan.size() > lost.length) {
            return n;
        } else {
            return n - (lost.length - reserveMan.size());
        }
    }
}
