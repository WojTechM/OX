package com.github.wojtechm;

/**
 * @author Makiela Wojciech
 */
abstract class Logger {

    private static Logger instance = null;

    static Logger getInstance() {
        if (instance == null) {
            instance = new Logger() {
                @Override
                public void display(String string) {
                    System.out.println(string);
                }
            };
        }
        return instance;
    }

    abstract void display(String string);
}
