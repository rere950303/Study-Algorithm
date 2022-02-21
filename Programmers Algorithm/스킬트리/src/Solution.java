//
// 규칙찾기(스킬트리)
// https://programmers.co.kr/learn/courses/30/lessons/49993
// Created by hyungwook on 2022/02/10.
//

import java.util.Arrays;

public class Solution {

    public int solution(String skill, String[] skill_trees) {
        int answer = (int) Arrays.stream(skill_trees).filter(skill_tree -> skill.startsWith(skill_tree.replaceAll("[^" + skill + "]", ""))).count();

        return answer;
    }
}