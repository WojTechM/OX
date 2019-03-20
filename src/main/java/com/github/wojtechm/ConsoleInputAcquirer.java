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
        int input = from - 1;
        while (input < from || input > to) {
            input = getIntFromUser();
        }
        return input;
    }

    String getStringFromUser() {
        return scanner.next();
    }

    Point getPointInRange(int width, int height) {
        String coordinateMessage = Settings.getInstance().getMessage("askForCoordinate");
        String rangeMessage = Settings.getInstance().getMessage("requireNumberInRange");

        Logger.getInstance().display(String.format(coordinateMessage, "X"));
        Logger.getInstance().display(String.format(rangeMessage, 0, width - 1));
        int x = getIntInRangeFromUser(0, width - 1);

        Logger.getInstance().display(String.format(coordinateMessage, "Y"));
        Logger.getInstance().display(String.format(rangeMessage, 0, height - 1));
        int y = getIntInRangeFromUser(0, height - 1);

        return new Point(x, y);
    }
}
