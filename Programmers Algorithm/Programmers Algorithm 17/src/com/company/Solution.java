//
//  Programmers Algorithm 17(소수 찾기)
//  https://programmers.co.kr/learn/courses/30/lessons/42839
//  Created by hyungwook on 2021/07/11.
//
package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Solution {
    public int solution(String numbers) {
        int length = numbers.length();
        boolean[] booleans = new boolean[length];
        char[] chars = numbers.toCharArray();
        Arrays.sort(chars);
        int descendingNum = Integer.parseInt(new StringBuffer(new String(chars)).reverse().toString());
        ArrayList<String> primeList = getPrimeList(descendingNum).stream().map(String::valueOf).collect(Collectors.toCollection(ArrayList::new));
        HashSet<Integer> combination = new HashSet<>();
        StringBuilder result = new StringBuilder();
        Answer answer = new Answer(0);

        for (boolean aBoolean : booleans) {
            aBoolean = false;
        }

        for (int i = 1; i <= length; i++) {
            getCombination(i, chars, length, booleans, result, combination, primeList, answer);
        }

        return answer.getAnswer();
    }

    private void getCombination(int i, char[] chars, int length, boolean[] booleans, StringBuilder result, HashSet<Integer> combination, ArrayList<String> primeList, Answer answer) {

        for (int j = 0; j < length; j++) {
            if (booleans[j] == false) {
                result.append(String.valueOf(chars[j]));
                if (result.length() == i && !combination.contains(Integer.parseInt(String.valueOf(result)))) {
                    combination.add(Integer.parseInt(String.valueOf(result)));
                    if (primeList.contains(result.toString())) {
                        System.out.println("result = " + result);
                        answer.setAnswer(answer.getAnswer() + 1);
                    }
                    result.setLength(result.length() - 1);
                } else {
                    booleans[j] = true;
                    getCombination(i, chars, length, booleans, result, combination, primeList, answer);
                    result.setLength(result.length() - 1);
                    booleans[j] = false;
                }
            }
        }
    }

    public ArrayList<Integer> getPrimeList(int descendingNum) {
        ArrayList<Integer> primeList = new ArrayList<>();

        primeList.add(2);
        primeList.add(3);

        for (int n = 5; n <= descendingNum; n += 2) {
            int flag = 0;

            for (int i = 1; primeList.get(i) * primeList.get(i) <= n; i++) {
                if (n % primeList.get(i) == 0) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 0) {
                primeList.add(n);
            }
        }

        return primeList;
    }
}
