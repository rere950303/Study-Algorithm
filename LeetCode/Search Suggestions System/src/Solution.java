//
// Trie, String, Array(Search Suggestions System)
// https://leetcode.com/problems/search-suggestions-system/
// Created by hyungwook on 2022/03/15.
//

import java.util.*;

public class Solution {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node root = new Node();

        for (String product : products) {
            Node tmp = root;

            for (char c : product.toCharArray()) {
                Node node = tmp.map.getOrDefault(c, new Node());
                node.suggestion.add(product);
                tmp.map.put(c, node);
                tmp = node;
            }
        }

        List<List<String>> answer = new ArrayList<>();
        Node tmp = root;
        boolean flag = true;

        for (char c : searchWord.toCharArray()) {
            if (tmp.map.containsKey(c) && flag) {
                List<String> list = tmp.map.get(c).suggestion;
                Collections.sort(list);
                answer.add(list.size() > 3 ? list.subList(0, 3) : list);
                tmp = tmp.map.get(c);
            } else {
                flag = false;
                answer.add(new ArrayList<>());
            }
        }

        return answer;
    }

    static class Node {
        HashMap<Character, Node> map = new HashMap<>();
        List<String> suggestion = new ArrayList<>();
    }
}