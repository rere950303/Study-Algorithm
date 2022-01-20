//
// 규칙 찾기(방금그곡)
// https://programmers.co.kr/learn/courses/30/lessons/17683
// Created by hyungwook on 2021/12/22.
//

import java.util.regex.Pattern;

public class Solution {

    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        long maxInterval = 0;
        Pattern pattern;

        if (m.charAt(m.length() - 1) == '#') {
            pattern = Pattern.compile(m);
        } else {
            pattern = Pattern.compile(m + "([^#]|$)");
        }

        for (String musicinfo : musicinfos) {
            String[] split = musicinfo.split(",");
            String sheet = split[3];
            StringBuffer melody = new StringBuffer();

            int len = sheet.length();
            long min1 = toMin(split[0]);
            long min2 = toMin(split[1]);
            long interval = min2 - min1;
            int pc = 0;

            for (int i = 0; i < interval; i++) {
                melody.append(sheet.charAt(pc++ % len));
                if (sheet.charAt(pc % len) == '#') {
                    melody.append(sheet.charAt(pc++ % len));
                }
            }

            if (pattern.matcher(melody).find() && interval > maxInterval) {
                maxInterval = interval;
                answer = split[2];
            }
        }

        return answer;
    }

    private long toMin(String s) {
        String[] split = s.split(":");
        return Integer.valueOf(split[0]) * 60 + Integer.valueOf(split[1]);
    }
}