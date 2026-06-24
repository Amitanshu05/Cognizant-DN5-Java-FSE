package com.cognizant.singleton;

public class Logger {

    // 1. Ek hi instance store karne ke liye static variable
    private static volatile Logger instance;

    // 2. Private constructor banaya taaki bahar se koi 'new' use na kar sake
    private Logger() {
        if (instance != null) {
            throw new IllegalStateException("Instance already created. Use getInstance() method.");
        }
    }

    // 3. Global access point (Gateway)
    public static Logger getInstance() {
        if (instance == null) { // Pehla check
            synchronized (Logger.class) { // Lock lagaya (Thread safety)
                if (instance == null) { // Dusra check (Double-checked locking)
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + System.currentTimeMillis() + " : " + message);
    }
}