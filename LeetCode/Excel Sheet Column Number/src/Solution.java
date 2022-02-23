//
// Math, String(Excel Sheet Column Number)
// https://leetcode.com/problems/excel-sheet-column-number/
// Created by hyungwook on 2022/02/23.
//

public class Solution {

    public int titleToNumber(String columnTitle) {
        int answer = 0;
        int length = columnTitle.length();

        for (int i = 0; i < length; i++) {
            answer += Math.pow(26, length - i - 1) * (columnTitle.charAt(i) - 64);
        }

        return answer;
    }
}
