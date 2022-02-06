//
// 규칙 찾기(멀쩡한 사각형)
// https://programmers.co.kr/learn/courses/30/lessons/62048?language=java
// Created by hyungwook on 2022/02/01.
//

public class Solution {

    public long solution(int w, int h) {
        return (long) w * h - (w + h - gcd(w, h));
    }

    private int gcd(int w, int h) {
        if (w % h == 0) {
            return h;
        }

        return gcd(h, w % h);
    }
}
