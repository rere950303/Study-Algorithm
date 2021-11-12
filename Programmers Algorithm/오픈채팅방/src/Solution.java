//
// HashMap(오픈채팅방)
// https://programmers.co.kr/learn/courses/30/lessons/42888?language=java
// Created by hyungwook on 2021/11/09.
//

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        for (String s : record) {
            String[] split = s.split(" ");
            if (split[0].equals("Enter") || split[0].equals("Change")) {
                map.put(split[1], split[2]);
            }
        }

        for (String s : record) {
            String[] split = s.split(" ");
            if (split[0].equals("Enter")) {
                list.add(new String(map.get(split[1]) + "님이 들어왔습니다."));
            } else if (split[0].equals("Leave")) {
                list.add(new String(map.get(split[1]) + "님이 나갔습니다."));
            }
        }

        return list.toArray(new String[list.size()]);
    }
}
