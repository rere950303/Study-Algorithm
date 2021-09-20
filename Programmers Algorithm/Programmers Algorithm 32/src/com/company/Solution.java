//
//  Programmers Algorithm 32(여행경로)
//  https://programmers.co.kr/learn/courses/30/lessons/43164
//  Created by hyungwook on 2021/08/01.
//

package com.company;

import java.util.ArrayList;

public class Solution {
    //모든 경로를 찍는 경로를 담는 배열
    String[] temp = new String[10000];

    ArrayList<String> answer = new ArrayList<String>();
    int length;
    int count = 0;

    public String[] solution(String[][] tickets) {
        this.length = tickets.length;
        Boolean[] check = new Boolean[length];

        //경로 경유여부 체크 배열
        for (int i = 0; i < length; i++) {
            check[i] = true;
        }

        for (int i = 0; i < length; i++) {
            if (tickets[i][0].equals("ICN")) {
                check[i] = false;
                temp[count] = "ICN";
                dfs(count + 1, check, tickets, tickets[i][0], tickets[i][1]);
                check[i] = true;
            }
        }

        return answer.stream().toArray(String[]::new);
    }

    void dfs(int count, Boolean[] check, String[][] tickets, String start, String end) {
        if (count == length) {
            temp[count] = end;
            if (answer.size() == 0) {
                // 첫 경로시 그냥 바로 담기
                insert();
            } else {
                // 두번째 경로부터 알파벳 비교하여 담기
                descendAlphabet();
            }
        }

        for (int i = 0; i < length; i++) {
            if (check[i] && end.equals(tickets[i][0])) {
                temp[count] = tickets[i][0];
                check[i] = false;
                dfs(count + 1, check, tickets, tickets[i][0], tickets[i][1]);
                check[i] = true;
            }

        }
    }

    public void insert() {
        for (int i = 0; i < length + 1; i++) {
            answer.add(temp[i]);
        }
    }

    public void descendAlphabet() {
        for (int i = 0; i < length + 1; i++) {
            if (answer.get(i).equals(temp[i])) {
                continue;
            } else if (answer.get(i).compareTo(temp[i]) > 0) {
                answer.clear();
                insert();
            } else {
                break;
            }
        }
    }
}
