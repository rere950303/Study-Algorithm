//
// Hash Table, Tire, String(Replace Words)
// https://leetcode.com/problems/replace-words/
// Created by hyungwook on 2022/03/06.
//

import java.util.HashMap;
import java.util.List;

public class Solution {

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie root = new Trie();

        for (String d : dictionary) {
            Trie node = root;

            for (char c : d.toCharArray()) {
                if (!node.map.containsKey(c)) {
                    node.map.put(c, new Trie());
                }
                node = node.map.get(c);
            }

            node.d = d;
        }

        StringBuilder stringBuilder = new StringBuilder();
        String[] words = sentence.split(" ");

        for (String word : words) {
            Trie node = root;
            String tmp = word;

            for (char c : word.toCharArray()) {
                if (node.d != null) {
                    tmp = node.d;
                    break;
                } else if (!node.map.containsKey(c)) {
                    break;
                } else {
                    node = node.map.get(c);
                }
            }
            stringBuilder.append(tmp + " ");
        }

        return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
    }

    static class Trie {
        HashMap<Character, Trie> map = new HashMap<>();
        String d;
    }
}