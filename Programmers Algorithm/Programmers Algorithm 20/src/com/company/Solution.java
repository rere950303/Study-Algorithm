//
//  Programmers Algorithm 20(조이스틱)
//  https://programmers.co.kr/learn/courses/30/lessons/42860?language=java
//  Created by hyungwook on 2021/07/15.
//

package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.reducing;

public class Solution {
    public int solution(String name) {
        // 경로 조합
        ArrayList<Integer> combination = new ArrayList<>();
        // 노드 사이 거리
        ArrayList<Integer> lengthList = new ArrayList<>();
        // A가 아닌 문자의 인덱스
        ArrayList<Integer> notAIndex = new ArrayList<>();
        // 노드 조합
        ArrayList<Node> nodes = new ArrayList<>();
        int answer = 0;

        char[] replaceA = name.replaceAll("A", "").toCharArray();
        for (char c : replaceA) {
            if (c > 'N') {
                answer += 'Z' - c + 1;
            } else {
                answer += c - 'A';
            }
        }

        char[] names = name.toCharArray();
        int length = name.length();

        for (int i = 0; i < length; i++) {
            if (names[i] != 'A') {
                notAIndex.add(i);
            }
        }

        if (notAIndex.size() == 0) {
            return 0;
        }

        // 시작점 인덱스가 0이므로 0이었으면 0추가
        if (notAIndex.get(0) != 0) {
            notAIndex.add(0);
            Collections.sort(notAIndex);
        }

        int size = notAIndex.size();

        for (int i = 0; i < size - 1; i++) {
            int i1 = notAIndex.get(i + 1) - notAIndex.get(i);
            int i2 = length - notAIndex.get(i + 1) + notAIndex.get(i);
            int i3 = i1 < i2 ? i1 : i2;
            lengthList.add(i3);
            nodes.add(new Node(notAIndex.get(i), notAIndex.get(i + 1), i3));
        }

        int i1 = notAIndex.get(notAIndex.size() - 1) - notAIndex.get(0);
        int i2 = length - notAIndex.get(notAIndex.size() - 1) + notAIndex.get(0);
        int i3 = i1 < i2 ? i1 : i2;
        lengthList.add(i3);
        nodes.add(new Node(notAIndex.get(0), notAIndex.get(notAIndex.size() - 1), i3));

        combination.add(lengthList.stream().collect(reducing(0, (i, j) -> i + j)) - lengthList.get(0));
        combination.add(lengthList.stream().collect(reducing(0, (i, j) -> i + j)) - lengthList.get(lengthList.size() - 1));

        Collections.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.getLength() - o1.getLength();
            }
        });

        int maxLength = nodes.get(0).getLength();

        // 최장 거리의 시작점이 0이라면 그 길이를 제외한 모든길이의 합이 답이됨
        ArrayList<Node> collect = nodes.stream().filter((Node node) -> node.getLength() == maxLength).sorted(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.getStart() - o2.getStart();
            }
        }).collect(Collectors.toCollection(ArrayList<Node>::new));

        int start = collect.get(0).getStart();
        nodes.remove(0);

        if (start == 0) {
            return answer + nodes.stream().collect(reducing(0, Node::getLength, (i, j) -> i + j));
        } else {
            int i = lengthList.indexOf(maxLength);
            int length1 = 0;
            int length2 = 0;

            for (int j = 0; j < i; j++) {
                length1 += lengthList.get(j);
            }

            for (int j = i + 1; j < lengthList.size(); j++) {
                length2 += lengthList.get(j);
            }

            combination.add(length1 * 2 + length2);
            combination.add(length2 * 2 + length1);
            Collections.sort(combination);

            return answer + combination.get(0);
        }
    }
}
