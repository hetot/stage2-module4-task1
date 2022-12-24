package com.mjc.stage2;

public class ThreadSafeSingleton {

    private ThreadSafeSingleton() {
    }

    private static final class InstanceHolder {
        private static final ThreadSafeSingleton instance = new ThreadSafeSingleton();
    }

    public static ThreadSafeSingleton getInstance() {
        return InstanceHolder.instance;
    }
}
