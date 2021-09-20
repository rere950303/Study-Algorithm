//
//  Programmers Algorithm 2(완주하지 못한 선수)
//  https://programmers.co.kr/learn/courses/30/lessons/42576
//  Created by hyungwook on 2021/06/26.
//

package com.company;

import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> parti = new HashMap<String, Integer>();

        int length_parti = participant.length;
        int length_comp = completion.length;

        for(int i = 0; i < length_parti; i++)
        {
            if(parti.containsKey(participant[i]) == false)
            {
                parti.put(participant[i], 1);
            }
            else
            {
                Integer value = parti.get(participant[i]);
                parti.put(participant[i], value + 1);
            }
        }

        for(int i = 0; i < length_comp; i++)
        {
            Integer value = parti.get(completion[i]);
            parti.put(completion[i], value - 1);
        }

        for(int i = 0; i < length_parti; i++)
        {
            if(parti.get(participant[i]).equals(1))
            {
                answer += participant[i];
                break;
            }
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
	// write your code here
    }
}
