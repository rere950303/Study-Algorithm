//
//  Programmers Algorithm 3(전화번호 목록)
//  https://programmers.co.kr/learn/courses/30/lessons/42577
//  Created by hyungwook on 2021/06/27.
//

package com.company;

import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        int len = phone_book.length;

        Arrays.sort(phone_book);

        for(int i = 0; i < len - 1; i++)
        {
            if(phone_book[i + 1].startsWith(phone_book[i]))
            {
                answer = false;
                return answer;
            }
        }
        return  answer;
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
