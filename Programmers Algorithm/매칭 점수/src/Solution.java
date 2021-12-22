//
// 정규표현식(매칭 점수)
// https://programmers.co.kr/learn/courses/30/lessons/42893
// Created by hyungwook on 2021/12/11.
//

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public int solution(String word, String[] pages) {
        String wordToLower = word.toLowerCase();
        int wordLen = wordToLower.length();
        int length = pages.length;
        HashMap<String, Score> map = new HashMap<>();
        ArrayList<String> contentList = new ArrayList<>();

        Pattern externalLinkPattern = Pattern.compile("<a href=(?:\\S+)https://([a-zA-Z0-9./\\\\]+)");
        Pattern contentPattern = Pattern.compile("<meta property=\\\"og:url\\\" content=(?:\\S+)https://([a-zA-Z0-9./\\\\]+)");

        for (String page : pages) {
            String pageToLower = page.toLowerCase();
            Matcher contentMatcher = contentPattern.matcher(page);
            String key = "";

            if (contentMatcher.find()) {
                key = contentMatcher.group(1);
                contentList.add(key);
            }

            int tmp = 0;
            int find = pageToLower.indexOf(wordToLower);

            while (find > 0) {
                if (!Character.isLetter(pageToLower.charAt(find - 1)) && !Character.isLetter(pageToLower.charAt(find + wordLen))) {
                    tmp++;
                }
                find = pageToLower.indexOf(wordToLower, find + 1);
            }
            map.put(key, new Score(tmp));
        }

        for (int i = 0; i < length; i++) {
            Matcher externalLinkMatcher = externalLinkPattern.matcher(pages[i]);
            int tmp = 0;
            ArrayList<String> list = new ArrayList<>();

            while (externalLinkMatcher.find()) {
                tmp++;
                list.add(externalLinkMatcher.group(1));
            }

            for (String s : list) {
                if (map.containsKey(s)) {
                    Score score = map.get(s);
                    score.e += map.get(contentList.get(i)).b / tmp;
                }
            }
        }

        double max = -1;
        int answer = 0;

        for (int i = 0; i < length; i++) {
            Score score = map.get(contentList.get(i));
            if (max < score.b + score.e) {
                max = score.b + score.e;
                answer = i;
            }
        }

        return answer;
    }

    static class Score {
        double b;
        double e;

        public Score(int b) {
            this.b = b;
        }
    }
}