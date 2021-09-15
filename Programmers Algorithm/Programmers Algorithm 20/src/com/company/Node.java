package com.company;

public class Node {

    private int start;
    private int end;
    private int length;

    public Node(int start, int end, int length) {
        this.start = start;
        this.end = end;
        this.length = length;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
