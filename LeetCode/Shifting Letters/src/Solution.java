//
// Array, String(Shifting Letters)
// https://leetcode.com/problems/shifting-letters/
// Created by hyungwook on 2022/03/08.
//

public class Solution {

    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder stringBuilder = new StringBuilder(s);
        long sum = 0;
        char[] arr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        for (int i = shifts.length - 1; i >= 0; i--) {
            sum += shifts[i];
            stringBuilder.setCharAt(i, arr[(int) ((stringBuilder.charAt(i) - 'a' + sum) % 26)]);
        }

        return stringBuilder.toString();
    }
}