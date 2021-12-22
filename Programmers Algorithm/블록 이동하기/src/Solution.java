import java.util.LinkedList;

public class Solution {

    int n;
    int[][] dir;
    boolean[][] row;
    boolean[][] col;
    LinkedList<Point> queue;
    int[][] board;

    public int solution(int[][] board) {
        this.dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        queue = new LinkedList<>();
        this.board = board;
        n = board.length;
        row = new boolean[n][n];
        col = new boolean[n][n];
        int answer = 0;
        queue.add(new Point(0, 0, 0, 1));
        int l = 1;
        row[0][0] = true;
        row[0][1] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Point point = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int r1x = point.r1 + dir[j][0];
                    int c1x = point.c1 + dir[j][1];
                    int r2x = point.r2 + dir[j][0];
                    int c2x = point.c2 + dir[j][1];

                    if (check(r1x, c1x, r2x, c2x)) {
                        queue.add(new Point(r1x, c1x, r2x, c2x));
                        if (r1x == n - 1 && c1x == n - 1 || r2x == n - 1 && c2x == n - 1) {
                            return l;
                        }
                    }
                }

                if (leftDownRot(point)) {
                    return l;
                }
                if (leftUpRot(point)) {
                    return l;
                }
                if (rightDownRot(point)) {
                    return l;
                }
                if (rightUpRot(point)) {
                    return l;
                }
            }
            l++;
        }

        return l;
    }

    private boolean rightUpRot(Point point) {
        if (point.r1 == point.r2) {
            int r1x = point.r1 - 1;
            int c1x = point.c1 + 1;

            if (r1x >= 0 && r1x < n && c1x >= 0 && c1x < n && board[point.r1 - 1][point.c2] == 0 && board[r1x][c1x] == 0 && board[point.r2][point.c2] == 0 && (!col[c1x][r1x] || !col[c1x][point.r2])) {
                col[c1x][r1x] = col[c1x][point.r2] = true;
                queue.add(new Point(r1x, c1x, point.r2, point.c2));
                if (r1x == n - 1 && c1x == n - 1 || point.r2 == n - 1 && point.c2 == n - 1) {
                    return true;
                }
            }
            return false;
        } else {
            int r2x = point.r2 - 1;
            int c2x = point.c2 + 1;

            if (r2x >= 0 && r2x < n && c2x >= 0 && c2x < n && board[point.r2][point.c2 + 1] == 0 && board[r2x][c2x] == 0 && board[point.r1][point.c1] == 0 && (!row[r2x][c2x] || !row[r2x][point.c1])) {
                row[r2x][c2x] = row[r2x][point.c1] = true;
                queue.add(new Point(point.r1, point.c1, r2x, c2x));
                if (r2x == n - 1 && c2x == n - 1 || point.r2 == n - 1 && point.c2 == n - 1) {
                    return true;
                }
            }
            return false;
        }
    }

    private boolean rightDownRot(Point point) {
        if (point.r1 == point.r2) {
            int r1x = point.r2;
            int c1x = point.c2;
            int r2x = point.r1 + 1;
            int c2x = point.c1 + 1;

            if (r2x >= 0 && r2x < n && c2x >= 0 && c2x < n && board[point.r1 + 1][point.c2] == 0 && board[r1x][c1x] == 0 && board[r2x][c2x] == 0 && (!col[c2x][r1x] || !col[c2x][r2x])) {
                col[c2x][r1x] = col[c2x][r2x] = true;
                queue.add(new Point(r1x, c1x, r2x, c2x));
                if (r1x == n - 1 && c1x == n - 1 || r2x == n - 1 && c2x == n - 1) {
                    return true;
                }
            }
            return false;
        } else {
            int r1x = point.r2;
            int c1x = point.c2;
            int r2x = point.r1 + 1;
            int c2x = point.c1 + 1;

            if (r2x >= 0 && r2x < n && c2x >= 0 && c2x < n && board[point.r1][point.c2 + 1] == 0 && board[r1x][c1x] == 0 && board[r2x][c2x] == 0 && (!row[r1x][c1x] || !row[r1x][c2x])) {
                row[r1x][c1x] = row[r1x][c2x] = true;
                queue.add(new Point(r1x, c1x, r2x, c2x));
                if (r1x == n - 1 && c1x == n - 1 || r2x == n - 1 && c2x == n - 1) {
                    return true;
                }
            }
            return false;
        }
    }

    private boolean leftUpRot(Point point) {
        if (point.r1 == point.r2) {
            int r1x = point.r2 - 1;
            int c1x = point.c2 - 1;
            int r2x = point.r1;
            int c2x = point.c1;

            if (r1x >= 0 && r1x < n && c1x >= 0 && c1x < n && board[point.r2 - 1][point.c2] == 0 && board[r1x][c1x] == 0 && board[r2x][c2x] == 0 && (!col[c2x][r1x] || !col[c2x][r2x])) {
                col[c2x][r1x] = col[c2x][r2x] = true;
                queue.add(new Point(r1x, c1x, r2x, c2x));
                if (r1x == n - 1 && c1x == n - 1 || r2x == n - 1 && c2x == n - 1) {
                    return true;
                }
            }
            return false;
        } else {
            int r1x = point.r2 - 1;
            int c1x = point.c2 - 1;
            int r2x = point.r1;
            int c2x = point.c1;

            if (r1x >= 0 && r1x < n && c1x >= 0 && c1x < n && board[point.r2 - 1][point.c2] == 0 && board[r1x][c1x] == 0 && board[r2x][c2x] == 0 && (!row[r1x][c1x] || !row[r1x][c2x])) {
                row[r1x][c1x] = col[r1x][c2x] = true;
                queue.add(new Point(r1x, c1x, r2x, c2x));
                if (r1x == n - 1 && c1x == n - 1 || r2x == n - 1 && c2x == n - 1) {
                    return true;
                }
            }
            return false;
        }
    }

    private boolean leftDownRot(Point point) {
        if (point.r1 == point.r2) {
            int r2x = point.r2 + 1;
            int c2x = point.c2 - 1;

            if (r2x >= 0 && r2x < n && c2x >= 0 && c2x < n && board[point.r2 + 1][point.c2] == 0 && board[point.r1][point.c1] == 0 && board[r2x][c2x] == 0 && (!col[c2x][point.r1] || !col[c2x][r2x])) {
                col[c2x][point.r1] = col[c2x][r2x] = true;
                queue.add(new Point(point.r1, point.c2, r2x, c2x));
                if (point.r1 == n - 1 && point.c1 == n - 1 || r2x == n - 1 && c2x == n - 1) {
                    return true;
                }
            }
            return false;
        } else {
            int r1x = point.r1 + 1;
            int c1x = point.c1 - 1;

            if (r1x >= 0 && r1x < n && c1x >= 0 && c1x < n && board[point.r1][point.c1 - 1] == 0 && board[point.r1][point.c1] == 0 && board[r1x][c1x] == 0 && (!row[r1x][point.c1] || !row[r1x][c1x])) {
                row[r1x][point.c1] = row[r1x][c1x] = true;
                queue.add(new Point(r1x, c1x, point.r2, point.c2));
                if (r1x == n - 1 && c1x == n - 1 || point.r2 == n - 1 && point.c2 == n - 1) {
                    return true;
                }
            }
            return false;
        }
    }

    private boolean check(int r1x, int c1x, int r2x, int c2x) {
        if (r1x == r2x) {
            if (r1x >= 0 && r1x < n && c1x >= 0 && c1x < n && r2x >= 0 && r2x < n && c2x >= 0 && c2x < n && board[r1x][c1x] == 0 && board[r2x][c2x] == 0 && (!row[r1x][c1x] || !row[r1x][c2x])) {
                row[r1x][c1x] = row[r1x][c2x] = true;
                return true;
            }
            return false;
        } else {
            if (r1x >= 0 && r1x < n && c1x >= 0 && c1x < n && r2x >= 0 && r2x < n && c2x >= 0 && c2x < n && board[r1x][c1x] == 0 && board[r2x][c2x] == 0 && (!col[c1x][r1x] || !col[c1x][r2x])) {
                col[c1x][r1x] = col[c1x][r2x] = true;
                return true;
            }
            return false;
        }
    }

    static class Point {
        int r1;
        int c1;
        int r2;
        int c2;

        public Point(int r1, int c1, int r2, int c2) {
            this.r1 = r1;
            this.c1 = c1;
            this.r2 = r2;
            this.c2 = c2;
        }
    }
}