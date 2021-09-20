//
//  Programmers Algorithm 4(위장)
//  https://programmers.co.kr/learn/courses/30/lessons/42578?language=java
//  Created by hyungwook on 2021/06/28.
//

package com.company;

import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();

        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }

        for (Integer value : map.values()) {
            answer *= (value + 1);
        }
        return answer - 1;
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
