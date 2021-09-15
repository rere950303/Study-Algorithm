package com.company;

public class Element {
    private int number;
    private String comparison;

    public Element(int number, String comparison) {
        this.number = number;
        this.comparison = comparison;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getComparison() {
        return comparison;
    }

    public void setComparison(String comparison) {
        this.comparison = comparison;
    }
}
