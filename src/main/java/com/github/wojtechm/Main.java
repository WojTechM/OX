package com.github.wojtechm;

import java.util.Scanner;

/**
 * @author Makiela Wojciech
 */
public class Main {

    public static void main(String[] args) {

        ConsoleGameController consoleGameController = new ConsoleGameController(
                new ConsolePlayerCreator(),
                new ConsoleBoardCreator(),
                new ConsoleInputAcquirer(new Scanner(System.in)));

        consoleGameController.play();
    }
}
