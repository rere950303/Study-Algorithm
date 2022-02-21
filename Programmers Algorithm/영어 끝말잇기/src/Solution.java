//
// 규칙찾기(영어 끝말잇기)
// https://programmers.co.kr/learn/courses/30/lessons/12981
// Created by hyungwook on 2022/02/06.
//

import java.util.HashSet;

public class Solution {

    public int[] solution(int n, String[] words) {
        int length = words.length;
        int[] answer = new int[]{0, 0};
        char lastChar = words[0].charAt(0);
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < length; i++) {
            String word = words[i];
            if (!set.contains(word) && word.charAt(0) == lastChar) {
                set.add(word);
                lastChar = word.charAt(word.length() - 1);
            } else {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
        }

        return answer;
    }
}