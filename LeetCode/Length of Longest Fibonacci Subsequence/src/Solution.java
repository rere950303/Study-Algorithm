//
// DP, Hash Table(Length of Longest Fibonacci Subsequence)
// https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/
// Created by hyungwook on 2022/05/20.
//

import java.util.HashMap;

public class Solution {

    public int lenLongestFibSubseq(int[] arr) {
        int length = arr.length;
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        indexMap.put(arr[0], 0);
        indexMap.put(arr[1], 1);
        int answer = 0;
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int k = 2; k < arr.length; k++) {
            for (int j = k - 1; j >= 1; j--) {
                int i = indexMap.getOrDefault(arr[k] - arr[j], -1);

                if (i >= 0 && i < j) {
                    int count = countMap.getOrDefault(i * length + j, 2);
                    answer = Math.max(answer, count + 1);
                    countMap.put(j * length + k, count + 1);
                }
            }
            indexMap.put(arr[k], k);
        }

        return answer;
    }
}