package com.company;

public class Combination {

    private int Transverse;
    private int length;
    private int brownNum;

    public Combination(int transverse, int length, int brownNum) {
        Transverse = transverse;
        this.length = length;
        this.brownNum = brownNum;
    }

    public int getTransverse() {
        return Transverse;
    }

    public void setTransverse(int transverse) {
        Transverse = transverse;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getBrownNum() {
        return brownNum;
    }

    public void setBrownNum(int brownNum) {
        this.brownNum = brownNum;
    }
}
