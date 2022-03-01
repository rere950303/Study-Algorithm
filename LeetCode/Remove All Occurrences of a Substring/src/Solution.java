//
// String(Remove All Occurrences of a Substring)
// https://leetcode.com/problems/remove-all-occurrences-of-a-substring/
// Created by hyungwook on 2022/03/01.
//

public class Solution {

    public String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            s = s.replaceFirst(part, "");
        }

        return s;
    }
}