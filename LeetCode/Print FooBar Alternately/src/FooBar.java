//
// Concurrency(Print FooBar Alternately)
// https://leetcode.com/problems/print-foobar-alternately/
// Created by hyungwook on 2022/02/28.
//

public class FooBar {

    private int n;
    private final Object lock = new Object();
    private int count = 1;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                if (count != 1) {
                    lock.wait();
                }
                printFoo.run();
                count = 0;
                lock.notify();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                if (count != 0) {
                    lock.wait();
                }
                printBar.run();
                count = 1;
                lock.notifyAll();
            }
        }
    }
}