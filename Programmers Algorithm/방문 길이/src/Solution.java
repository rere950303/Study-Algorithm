//
// 규칙찾기(방문 길이)
// https://programmers.co.kr/learn/courses/30/lessons/49994
// Created by hyungwook on 2022/02/10.
//

import java.util.HashMap;

public class Solution {

    public int solution(String dirs) {
        int answer = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        map.put('U', 0);
        map.put('R', 1);
        map.put('D', 2);
        map.put('L', 3);

        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        boolean[][][] check = new boolean[11][11][4];
        int r = 5;
        int c = 5;

        for (char ch : dirs.toCharArray()) {
            Integer move = map.get(ch);

            int rn = r + dir[move][0];
            int cn = c + dir[move][1];

            if (rn < 0 || rn > 10 || cn < 0 || cn > 10) {
                continue;
            }
            if (!check[r][c][move]) {
                check[r][c][move] = true;
                check[rn][cn][(move + 2) % 4] = true;
                answer++;
            }
            r = rn;
            c = cn;
        }

        return answer;
    }
}
