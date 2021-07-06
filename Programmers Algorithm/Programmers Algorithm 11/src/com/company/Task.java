package com.company;

public class Task {
    private int startingTime;
    private int loadingTime;
    private int counting;

    public Task(int startingTime, int loadingTime, int counting) {
        this.startingTime = startingTime;
        this.loadingTime = loadingTime;
        this.counting = counting;
    }

    public int getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(int startingTime) {
        this.startingTime = startingTime;
    }

    public int getLoadingTime() {
        return loadingTime;
    }

    public void setLoadingTime(int loadingTime) {
        this.loadingTime = loadingTime;
    }

    public int getCounting() {
        return counting;
    }

    public void setCounting(int counting) {
        this.counting = counting;
    }
}
