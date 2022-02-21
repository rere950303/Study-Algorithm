//
// 2015 Contest(LongestPassword)
// https://app.codility.com/programmers/trainings/1/flood_depth/
// Created by hyungwook on 2022/02/16.
//

public class Solution {

    public int solution(String S) {
        String[] split = S.split(" ");
        int answer = -1;

        for (String s : split) {
            answer = Math.max(answer, getLen(s));
        }

        return answer;
    }

    private int getLen(String s) {
        int nLetter = 0;
        int nDigit = 0;

        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                nLetter++;
            } else if (Character.isDigit(c)) {
                nDigit++;
            } else {
                return -1;
            }
        }

        if (nLetter % 2 == 0 && nDigit % 2 == 1) {
            return s.length();
        } else {
            return -1;
        }
    }
}
