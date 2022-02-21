//
// 규칙찾기(기지국 설치)
// https://programmers.co.kr/learn/courses/30/lessons/12979?language=java
// Created by hyungwook on 2022/02/13.
//

public class Solution {

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int length = stations.length;
        int width = 2 * w + 1;

        double first = Math.ceil((double) (stations[0] - w - 1) / width);
        answer += first < 0 ? 0 : first;

        for (int i = 0; i < length - 1; i++) {
            double medium = Math.ceil((double) ((stations[i + 1] - w) - (stations[i] + w + 1)) / width);
            answer += medium < 0 ? 0 : medium;
        }

        double last = Math.ceil((double) (n + 1 - (stations[length - 1] + w + 1)) / width);
        answer += last < 0 ? 0 : last;

        return answer;
    }
}