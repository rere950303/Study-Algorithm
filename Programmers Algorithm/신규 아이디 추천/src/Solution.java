//
// 기타(신규 아이디 추천)
// https://programmers.co.kr/learn/courses/30/lessons/72410?language=java
// Created by hyungwook on 2021/10/20.
//

public class Solution {

    public String solution(String new_id) {
        String step1 = new_id.toLowerCase();
        String step2 = step1.replaceAll("[^-_.a-z0-9]", "");
        String step3 = step2.replaceAll("[.]{2,}", ".");
        String step4 = step3.replaceAll("^[.]|[.]$", "");
        String step5 = step4;
        if (step4.equals("")) {
            step5 = "a";
        }

        String step6 = step5;
        if (step5.length() > 15) {
            step6 = step5.substring(0, 15);
            step6 = step6.replaceAll("[.]$", "");
        }

        String step7 = step6;
        if (step6.length() <= 2) {
            char c = step6.charAt(step6.length() - 1);

            while (step7.length() < 3) {
                step7 = step7 + c;
            }
        }

        return step7;
    }
}
