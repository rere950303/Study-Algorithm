//
// Prefix Sums(CountDiv)
// https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/
// Created by hyungwook on 2021/10/02.
//

public class Solution {

    public int solution(int A, int B, int K) {
        int start = A % K == 0 ? A : K * (A / K + 1);
        int end = B % K == 0 ? B : K * (B / K);

        return (end - start) / K + 1;
    }
}
