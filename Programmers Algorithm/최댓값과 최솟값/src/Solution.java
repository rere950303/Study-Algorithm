//
// 규칙찾기(최댓값과 최솟값)
// https://programmers.co.kr/learn/courses/30/lessons/12939?language=java
// Created by hyungwook on 2022/02/17.
//

public class Solution {

    public String solution(String s) {
        String[] split = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (String num : split) {
            Integer integer = Integer.valueOf(num);
            max = Math.max(max, integer);
            min = Math.min(min, integer);
        }

        return min + " " + max;
    }
}
