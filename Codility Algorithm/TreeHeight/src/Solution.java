//
// Algorithmic skills(TreeHeight)
// https://app.codility.com/programmers/trainings/4/tree_height/
// Created by hyungwook on 2022/02/18.
//

public class Solution {

    public int solution(Tree T) {
        if (T == null) {
            return 0;
        }

        return Math.max(solution(T.l), solution(T.r)) + 1;
    }

    static class Tree {
        public int x;
        public Tree l;
        public Tree r;
    }
}