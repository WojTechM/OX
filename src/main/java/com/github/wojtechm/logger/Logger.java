package com.github.wojtechm.logger;

/**
 * Default Output path used by OxGame
 *
 * @author Makiela Wojciech
 */
public abstract class Logger {

    private static Logger instance = null;

    public static Logger getInstance() {
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

    public abstract void display(String string);
}
