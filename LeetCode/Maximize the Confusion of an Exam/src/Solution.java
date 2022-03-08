//
// String, Sliding Window, Two Pointer, Prefix Sum(Maximize the Confusion of an Exam)
// https://leetcode.com/problems/maximize-the-confusion-of-an-exam/
// Created by hyungwook on 2022/03/07.
//

public class Solution {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] arr = answerKey.toCharArray();
        int[] count = new int[26];
        int freq = 0;
        int len = 0;

        for (int pr = 0; pr < arr.length; pr++) {
            freq = Math.max(freq, ++count[arr[pr] - 'A']);

            if (len - freq < k) {
                len++;
            } else {
                count[arr[pr - len] - 'A']--;
            }
        }

        return len;
    }
}