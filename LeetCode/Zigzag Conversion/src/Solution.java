//
// String(Zigzag Conversion)
// https://leetcode.com/problems/zigzag-conversion/
// Created by hyungwook on 2022/02/24.
//

public class Solution {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        int length = s.length();
        int interval = (numRows - 1) * 2;
        StringBuilder stringBuilder = new StringBuilder();
        int idx = 0;

        while (idx < length) {
            stringBuilder.append(s.charAt(idx));
            idx += interval;
        }

        int midInterval = interval - 2;

        for (int i = 1; i < numRows - 1; i++) {
            int start = i;

            while (start < length) {
                stringBuilder.append(s.charAt(start));
                if (start + midInterval < length) {
                    stringBuilder.append(s.charAt(start + midInterval));
                }
                start += interval;
            }
            midInterval -= 2;
        }

        idx = numRows - 1;
        while (idx < length) {
            stringBuilder.append(s.charAt(idx));
            idx += interval;
        }

        return stringBuilder.toString();
    }
}