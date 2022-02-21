//
// Algorithmic skills(PolygonConcavityIndex)
// https://app.codility.com/demo/results/trainingAK6KXC-UC9/
// Created by hyungwook on 2022/02/18.
//

public class Solution {

    public int solution(Point2D[] A) {
        int length = A.length;
        int minY = A[0].y;
        int lastIdx = 0;

        for (int i = 0; i < length; i++) {
            if (minY >= A[i].y) {
                minY = A[i].y;
                lastIdx = i;
            }
        }

        int previous = (lastIdx - 1 + length) % length;
        int current = lastIdx;
        int next = (lastIdx + 1) % length;
        int dir = 0;

        for (int i = 0; i < length; i++) {
            int tmp = getRotDir(A[previous], A[current], A[next]);
            if (tmp != 0) {
                dir = tmp;
                break;
            }
            current = (current + i) % length;
            previous = (current - 1 + length) % length;
            next = (current + 1) % length;
        }

        if (dir == 0) {
            return -1;
        }

        for (int i = 0; i < length; i++) {
            current = (lastIdx + i) % length;
            previous = (current - 1 + length) % length;
            next = (current + 1) % length;

            int tmp = getRotDir(A[previous], A[current], A[next]);

            if (tmp * dir < 0) {
                return current;
            }
        }

        return -1;
    }

    private int getRotDir(Point2D p1, Point2D p2, Point2D p3) {
        long tmp = (((long) p2.x - (long) p1.x) * ((long) p3.y - (long) p1.y)) - (((long) p2.y - (long) p1.y) * ((long) p3.x - (long) p1.x));
        int dir = 0;

        if (tmp < 0) {
            dir = -1;
        } else if (tmp > 0) {
            dir = 1;
        }

        return dir;
    }

    static class Point2D {
        int x;
        int y;

        public Point2D(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}