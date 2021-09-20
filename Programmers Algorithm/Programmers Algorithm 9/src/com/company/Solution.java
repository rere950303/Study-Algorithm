//
//  Programmers Algorithm 9(주식가격)
//  https://programmers.co.kr/learn/courses/30/lessons/42584
//  Created by hyungwook on 2021/07/03.
//

package com.company;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] prices) {
        List<Integer> answer = new ArrayList<>();
        int length = prices.length;

        for(int i = 0; i < length - 1; i++)
        {
            int count = 0;

            for(int j = i + 1; j < length; j++)
            {
                count++;

                if(prices[i] <= prices[j])
                {
                    continue;
                }
                else
                    break;
            }
            answer.add(count);
        }

        answer.add(0);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
