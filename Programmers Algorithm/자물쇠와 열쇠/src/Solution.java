//
// 규칙 찾기(자물쇠와 열쇠)
// https://programmers.co.kr/learn/courses/30/lessons/60059
// Created by hyungwook on 2021/11/18.
//

public class Solution {
    int keyLen;
    int lockLen;

    public boolean solution(int[][] key, int[][] lock) {
        this.keyLen = key.length;
        this.lockLen = lock.length;

        for (int k = 0; k < 4; k++) {
            key = rotate(key);
            for (int i = 0; i < lock.length + key.length -1; i++) {
                for (int j = 0; j < lock.length + key.length - 1; j++) {
                    int[][] newLock = new int[lock.length + (key.length - 1) * 2][lock.length + (key.length - 1) * 2];
                    initNewLock(newLock, lock);
                    add(i, j, key, newLock);
                    if (isFit(newLock)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private int[][] rotate(int[][] key) {
        int[][] tmp = new int[keyLen][keyLen];

        for (int i = 0; i < keyLen; i++) {
            for (int j = 0; j < keyLen; j++) {
                if (key[i][j] == 1) {
                    tmp[j][keyLen - 1 - i] = 1;
                }
            }
        }

        return tmp;
    }

    private void initNewLock(int[][] newLock, int[][] lock) {
        for (int i = keyLen - 1; i < keyLen - 1 + lockLen; i++) {
            for (int j = keyLen - 1; j < keyLen - 1 + lockLen; j++) {
                newLock[i][j] = lock[i - keyLen + 1][j - keyLen + 1];
            }
        }
    }

    private void add(int r, int c, int[][] key, int[][] newLock) {
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                newLock[r + i][c + j] += key[i][j];
            }
        }
    }

    private boolean isFit(int[][] newLock) {
        for (int i = keyLen - 1; i < keyLen - 1 + lockLen; i++) {
            for (int j = keyLen - 1; j < keyLen - 1 + lockLen; j++) {
                if (newLock[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}