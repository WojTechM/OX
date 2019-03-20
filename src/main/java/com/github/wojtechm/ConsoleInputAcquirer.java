package com.github.wojtechm;

import java.util.Scanner;

/**
 * @author Makiela Wojciech
 */
class ConsoleInputAcquirer {

    private Scanner scanner;

    ConsoleInputAcquirer(Scanner scanner) {
        if (scanner == null) {
            throw new IllegalArgumentException("Console Input Acquirer cannot read from null");
        }
        this.scanner = scanner;
    }

    int getIntFromUser() {
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        return scanner.nextInt();
    }

    int getIntInRangeFromUser(int from, int to) {
        int input = from -1;
        while (input < from || input > to) {
            input = getIntFromUser();
        }
        return input;
    }

    String getStringFromUser() {
        return scanner.next();
    }

    Point getPointInRange(int width, int height) {
        Logger.getInstance().display("Type in X coordinate: ");
        int x = getIntInRangeFromUser(0, width);
        Logger.getInstance().display("Type in Y coordinate: ");
        int y = getIntInRangeFromUser(0, height);
        System.out.println(x + " " + y);
        return new Point(x, y);
    }
}
