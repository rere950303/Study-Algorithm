//
// 2016 Contest(RectangleBuilderGreaterArea)
// https://app.codility.com/programmers/trainings/2/rectangle_builder_greater_area/
// Created by hyungwook on 2022/02/16.
//

import java.util.*;

public class Solution {

    public int solution(int[] A, int X) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int a : A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        int answer = 0;

        Iterator<Integer> iterator = map.keySet().iterator();

        while (iterator.hasNext()) {
            Integer key = iterator.next();
            Integer num = map.get(key);

            if (num < 2) {
                iterator.remove();
            } else if (num >= 4 && (long) key * key >= X) {
                answer++;
            }
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        int size = list.size();

        for (int i = 0; i < size; i++) {
            int pl = i + 1;
            int pr = size - 1;
            int end = size;

            while (pl <= pr) {
                int pc = (pl + pr) / 2;

                if ((long) list.get(i) * list.get(pc) >= X) {
                    end = pc;
                    pr = pc - 1;
                } else {
                    pl = pc + 1;
                }
            }

            answer += size - end;

            if (answer > 1000000000) {
                return -1;
            }
        }

        return answer;
    }
}