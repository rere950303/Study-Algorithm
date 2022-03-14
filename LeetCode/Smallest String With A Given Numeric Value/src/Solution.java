//
// String, Greedy(Smallest String With A Given Numeric Value)
// https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/
// Created by hyungwook on 2022/03/13.
//

public class Solution {

    public String getSmallestString(int n, int k) {
        StringBuilder answer = new StringBuilder();

        while (n > 0) {
            if ((n - 1) * 26 >= k) {
                answer.append('a');
                k--;
            } else {
                answer.append((char) ((k - (n - 1) * 26) + 96));
                k -= (k - (n - 1) * 26);
            }
            n--;
        }

        return answer.toString();
    }
}