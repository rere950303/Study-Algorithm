//
// Sliding Window, String(Maximum Number of Vowels in a Substring of Given Length)
// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
// Created by hyungwook on 2022/05/27.
//

public class Solution {

    public int maxVowels(String s, int k) {
        int count = 0;

        for (int i = 0; i < k; i++) {
            if (isVowel(s, i)) {
                count++;
            }
        }

        int answer = 0;

        for (int i = k; i < s.length(); i++) {
            answer = Math.max(answer, count);

            if (isVowel(s, i)) {
                count++;
            }
            if (isVowel(s, i - k)) {
                count--;
            }
        }

        answer = Math.max(answer, count);

        return answer;
    }

    private boolean isVowel(String s, int i) {
        char c = s.charAt(i);

        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
