//
// Coding skills(ThreeLetters)
// https://app.codility.com/programmers/trainings/5/three_letters/
// Created by hyungwook on 2022/02/19.
//

public class Solution {

    public String solution(int A, int B) {
        StringBuilder stringBuilder = new StringBuilder();
        char target = ' ';
        int num = 0;

        if (A < B) {
            num = A;
            target = 'a';
            createBase(B, stringBuilder, 'b');
        } else {
            num = B;
            target = 'b';
            createBase(A, stringBuilder, 'a');
        }

        int idx = 2;
        int interval = 3;

        while (idx <= stringBuilder.length() && num > 0) {
            stringBuilder.insert(idx, target);
            idx += interval;
            num--;
        }

        idx = 1;
        interval = 4;

        while (num > 0) {
            stringBuilder.insert(idx, target);
            idx += interval;
            num--;
        }

        return stringBuilder.toString();
    }

    private void createBase(int num, StringBuilder stringBuilder, char baseChar) {
        for (int i = 0; i < num; i++) {
            stringBuilder.append(baseChar);
        }
    }
}