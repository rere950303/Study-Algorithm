//
//  Programmers Algorithm 31(단어 변환)
//  https://programmers.co.kr/learn/courses/30/lessons/43163
//  Created by hyungwook on 2021/07/31.
//
package com.company;

public class Solution {
    private Boolean[] check = new Boolean[50];
    private String target = new String();
    private int length;
    private int answer = 0;

    public int solution(String begin, String target, String[] words) {
        this.target = target;
        this.length = words.length;

        for (int i = 0; i < length; i++) {
            check[i] = true;
        }

        dfs(begin, 0, words);

        return answer;
    }

    public void dfs(String start, int count, String[] words) {
        if (start.equals(target)) {
            if (answer == 0) {
                answer = count;
            } else {
                answer = Math.min(answer, count);
            }
        }

        for (int i = 0; i < length; i++) {
            if (check[i] == true) {
                if (checkOne(start, words[i])) {
                    check[i] = false;
                    dfs(words[i], count + 1, words);
                    check[i] = true;
                }
            }
        }
    }

    private Boolean checkOne(String start, String word) {
        int count = 0;
        char[] startChar = start.toCharArray();
        char[] wordChar = word.toCharArray();
        int length = word.length();

        for (int i = 0; i < length; i++) {
            if (startChar[i] != wordChar[i]) {
                count++;
            }
        }

        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }
}


