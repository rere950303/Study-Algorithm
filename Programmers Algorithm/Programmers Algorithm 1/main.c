//
//  main.c
//  Programmers Algorithm 1(로또의 최고 순위와 최저 순위)
//  https://programmers.co.kr/learn/courses/30/lessons/77484
//  Created by hyungwook on 2021/06/26.
//

#include <stdio.h>
#include <stdlib.h>

int answer[2];

int* solution(int lottos[], size_t lottos_len, int win_nums[], size_t win_nums_len) {
    int count_o = 0;
    int count_zero = 0;
    
    for(int i = 0; i < lottos_len; i++)
    {
        if(lottos[i] == 0)
            count_zero++;
    }
    
    for(int i = 0 ; i < win_nums_len; i++)
    {
        for(int j = 0; j < lottos_len; j++)
        {
            if(win_nums[i] == lottos[j])
            {
                count_o++;
                break;
            }
        }
    }
    
    if(count_o != 0)
    {
        answer[0] = 7 - (count_o + count_zero);
        answer[1] = 7 - count_o;
    }
    
    else
    {
        if(count_zero == 0)
        {
            answer[0] = 6;
            answer[1] = 6;
        }
        else
        {
            answer[0] = 7 - count_zero;
            answer[1] = 6;
        }
    }
    
    return answer;
}
