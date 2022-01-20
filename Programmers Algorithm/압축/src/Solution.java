//
// 규칙 찾기(압축)
// https://programmers.co.kr/learn/courses/30/lessons/17684
// Created by hyungwook on 2021/12/23.
//

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

    public int[] solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        char[] arr = msg.toCharArray();
        int length = msg.length();
        int pc = 0;
        int index = 27;
        StringBuffer buffer = new StringBuffer();
        HashMap<String, Integer> map = new HashMap<>();

        init(map);

        while (pc < length) {
            buffer.append(arr[pc++]);
            while (pc < length && map.containsKey(new String(buffer.append(arr[pc])))) {
                pc++;
            }
            if (!map.containsKey(new String(buffer))) {
                map.put(String.valueOf(buffer), index++);
                answer.add(map.get(buffer.substring(0, buffer.length() - 1)));
            } else {
                answer.add(map.get(buffer.toString()));
            }
            buffer.delete(0, buffer.length());
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private void init(HashMap<String, Integer> map) {
        for (int i = 1; i <= 26; i++) {
            char a = (char) (i + 64);
            map.put(String.valueOf(a), i);
        }
    }
}