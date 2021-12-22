//
// Queue(캐시)
// https://programmers.co.kr/learn/courses/30/lessons/17680
// Created by hyungwook on 2021/12/01.
//

import java.util.LinkedList;

public class Solution {

    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return 5 * cities.length;
        }

        int answer = 0;
        int count = 0;

        LinkedList<String> queue = new LinkedList<>();

        for (String city : cities) {
            String toLowerCase = city.toLowerCase();

            if (queue.remove(toLowerCase)) {
                answer += 1;
                queue.addLast(toLowerCase);
            } else {
                if (count == cacheSize) {
                    queue.pollFirst();
                    queue.addLast(toLowerCase);
                } else {
                    queue.addLast(toLowerCase);
                    count++;
                }
                answer += 5;
            }
        }

        return answer;
    }
}
