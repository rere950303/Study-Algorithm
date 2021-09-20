//
//  Programmers Algorithm 14(https://programmers.co.kr/learn/courses/30/lessons/42746?language=java)
//  https://programmers.co.kr/learn/courses/30/lessons/42746?language=java
//  Created by hyungwook on 2021/07/08.
//

package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        ArrayList<Element> elements = new ArrayList<>();

        for (int number : numbers) {
            String s = String.valueOf(number);

            for (int i = 0; i < 3; i++) {
                s += s;
            }

            elements.add(new Element(number, s));
        }

        Collections.sort(elements, new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                String comparison1 = o1.getComparison();
                String comparison2 = o2.getComparison();
                return comparison2.compareTo(comparison1);
            }
        });

        for (Element element : elements) {
            answer += String.valueOf(element.getNumber());
        }

        int length = answer.length();
        int count = 0;

        for (int i = 0; i < length; i++) {
            if (answer.charAt(i) == '0') {
                count++;
            } else {
                break;
            }
        }

        if (count == length) {
            return String.valueOf(0);
        } else {
            return answer;
        }
    }
}
