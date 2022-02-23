//
// Trie(가사 검색)
// https://programmers.co.kr/learn/courses/30/lessons/60060
// Created by hyungwook on 2022/02/22.
//

import java.util.HashMap;

public class Solution {

    public int[] solution(String[] words, String[] queries) {
        Node root = new Node();
        Node reverseRoot = new Node();

        for (String word : words) {
            int len = word.length();

            Node tmp = root;
            makeTrie(tmp, len, word);

            tmp = reverseRoot;
            makeTrie(tmp, len, new StringBuilder(word).reverse().toString());
        }

        int length = queries.length;
        int[] answer = new int[length];

        for (int i = 0; i < length; i++) {
            String query = queries[i];
            int count;

            if (query.charAt(0) == '?') {
                count = getCount(new StringBuilder(query).reverse().toString(), reverseRoot);
            } else {
                count = getCount(query, root);
            }

            answer[i] = count;
        }

        return answer;
    }

    private void makeTrie(Node tmp, int len, String word) {
        tmp.lenCount.put(len, tmp.lenCount.getOrDefault(len, 0) + 1);

        for (char c : word.toCharArray()) {
            Node node;

            if (tmp.map.containsKey(c)) {
                node = tmp.map.get(c);
            } else {
                node = new Node();
                tmp.map.put(c, node);
            }

            node.lenCount.put(len, node.lenCount.getOrDefault(len, 0) + 1);
            tmp = node;
        }
    }

    private int getCount(String s, Node node) {
        if (s.charAt(0) == '?') {
            return node.lenCount.containsKey(s.length()) ? node.lenCount.get(s.length()) : 0;
        }

        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '?') {
                return node.lenCount.containsKey(s.length()) ? node.lenCount.get(s.length()) : 0;
            }
            if (!node.map.containsKey(c)) {
                return 0;
            } else {
                node = node.map.get(c);
            }
        }

        return count;
    }

    static class Node {
        HashMap<Character, Node> map = new HashMap();
        HashMap<Integer, Integer> lenCount = new HashMap();
    }
}