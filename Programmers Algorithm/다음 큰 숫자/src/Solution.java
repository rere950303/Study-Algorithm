//
// 규칙찾기(다음 큰 숫자)
// https://programmers.co.kr/learn/courses/30/lessons/12911
// Created by hyungwook on 2022/02/14.
//

public class Solution {

    public int solution(int n) {
        int target = n + 1;
        String nBinary = Integer.toBinaryString(n).replace("0", "");

        while (true) {
            String targetBinary = Integer.toBinaryString(target).replace("0", "");

            if (targetBinary.equals(nBinary)) {
                return target;
            }
            target++;
        }
    }
}