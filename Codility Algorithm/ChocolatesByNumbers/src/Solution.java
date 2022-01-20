//
// Euclidean algorithm(ChocolatesByNumbers)
// https://app.codility.com/programmers/lessons/12-euclidean_algorithm/chocolates_by_numbers/
// Created by hyungwook on 2021/12/22.
//

public class Solution {

    public int solution(int N, int M) {
        int gcd = gcd(N, M);

        return N / gcd;
    }

    private int gcd(int n, int m) {
        while (m != 0) {
            int remainder = n % m;
            n = m;
            m = remainder;
        }

        return n;
    }
}