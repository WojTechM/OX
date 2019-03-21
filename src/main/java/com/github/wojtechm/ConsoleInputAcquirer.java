package com.github.wojtechm;

import com.github.wojtechm.settings.Settings;

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

    int getIntFromUser() throws GameInterruptedByUserException {
        do {
            try {
                String input = scanner.nextLine();
                if (input.equals("!quit")) {
                    throw new GameInterruptedByUserException();
                }
                return Integer.parseInt(input);
            } catch (NumberFormatException ignored) {

            }
        } while (true);
    }

    int getIntInRangeFromUser(int from, int to) throws GameInterruptedByUserException {
        int input = from - 1;
        while (input < from || input > to) {
            input = getIntFromUser();
        }
        return input;
    }

    String getStringFromUser() throws GameInterruptedByUserException {
        String input = scanner.nextLine();
        if (input.equals("!quit")) {
            throw new GameInterruptedByUserException();
        }
        return input;
    }

    Point getPointInRange(int width, int height) throws GameInterruptedByUserException {
        String coordinateMessage = Settings.getInstance().getMessage("askForCoordinate");
        String rangeMessage = Settings.getInstance().getMessage("requireNumberInRange");

        Logger.getInstance().display(String.format(coordinateMessage, "X"));
        Logger.getInstance().display(String.format(rangeMessage, 1, width));
        int x = getIntInRangeFromUser(1, width);

        Logger.getInstance().display(String.format(coordinateMessage, "Y"));
        Logger.getInstance().display(String.format(rangeMessage, 1, height));
        int y = getIntInRangeFromUser(1, height);

        return new Point(x - 1, y - 1);
    }
}
