//
// Arrays(OddOccurrencesInArray)
//
// Created by hyungwook on 2021/09/24.
//

import java.util.HashMap;

public class Solution {

    public int solution(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        for (int i : A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Integer integer : map.keySet()) {
            if (map.get(integer) % 2 == 1) {
                answer = integer;
            }
        }

//        XOR연산은 결합, 교환법칙이 성립하며 같은 수를 연산하는 경우 0이 듸므로 최종 연산결과는 짝수어지는 수를 제외한 홀수개 존재하는 값이 반환되게 된다.
//        for (int i : A) {
//            answer = answer ^ i;
//        }

        return answer;
    }
}
