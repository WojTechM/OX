package com.github.wojtechm;

import org.testng.annotations.Test;

import java.util.Random;
import java.util.Scanner;

import static org.testng.Assert.*;

/**
 * @author Makiela Wojciech
 */
public class ConsoleInputAcquirerTest {

    private Random random = new Random();

    @Test
    private void Should_CreateInstance_When_PassedValidArgs_Otherwise_ThrowException() {
        new ConsoleInputAcquirer(new Scanner(System.in));
        assertThrows(IllegalArgumentException.class, () -> new ConsoleInputAcquirer(null));
    }

    @Test(invocationCount = 10)
    private void Should_ReturnInt_When_CalledAskUserForAnInteger() {
        StringBuilder stringBuilder = new StringBuilder();
        String letters = "qwertyuiopasdfghjklzxcvbnm";
        for (int n = 0; n < random.nextInt(6) + 1; n++) {
            stringBuilder.append(letters.charAt(random.nextInt(letters.length())));
            stringBuilder.append("\n");
        }

        int expected = random.nextInt(Integer.MAX_VALUE);

        stringBuilder.append(expected);
        stringBuilder.append("\n");

        for (int n = 0; n < random.nextInt(6) + 1; n++) {
            stringBuilder.append(letters.charAt(random.nextInt(letters.length())));
            stringBuilder.append("\n");
        }

        Scanner scanner = new Scanner(stringBuilder.toString());
        int actual = new ConsoleInputAcquirer(scanner).getIntFromUser();
        assert expected == actual;
    }

    @Test(invocationCount = 10)
    private void Should_ReturnIntFromGivenRange_When_CalledGetIntInRangeFromUser() {
        StringBuilder stringBuilder = new StringBuilder();
        int min = random.nextInt(100);
        int max = min + 1 + random.nextInt(100);
        String letters = "qwertyuiopasdfghjklzxcvbnm";
        for (int n = 0; n < random.nextInt(6) + 1; n++) {
            stringBuilder.append(letters.charAt(random.nextInt(letters.length())));
            stringBuilder.append("\n");
        }

        for (int n = 0; n < random.nextInt(6) + 1; n++) {
            stringBuilder.append(random.nextInt(200) + 1 + max);
            stringBuilder.append("\n");
        }


        int expected = random.nextInt(max - min) + 1 + min;

        stringBuilder.append(expected);
        stringBuilder.append("\n");

        Scanner scanner = new Scanner(stringBuilder.toString());
        int actual = new ConsoleInputAcquirer(scanner).getIntInRangeFromUser(min, max);
        assert expected == actual : String.format("Expected %s, got %s", expected, actual);
    }

    @Test(invocationCount = 10)
    private void Should_ReturnString_When_CalledGetIntInRangeFromUser() {
        StringBuilder stringBuilder = new StringBuilder();
        int min = random.nextInt(100);
        int max = min + 1 + random.nextInt(100);
        String letters = "qwertyuiopasdfghjklzxcvbnm";
        for (int n = 0; n < random.nextInt(6) + 1; n++) {
            stringBuilder.append(letters.charAt(random.nextInt(letters.length())));
            stringBuilder.append("\n");
        }

        for (int n = 0; n < random.nextInt(6) + 1; n++) {
            stringBuilder.append(random.nextInt(200) + max + 1);
            stringBuilder.append("\n");
        }


        int expected = random.nextInt(max - min) + 1 + min;

        stringBuilder.append(expected);
        stringBuilder.append("\n");

        Scanner scanner = new Scanner(stringBuilder.toString());
        int actual = new ConsoleInputAcquirer(scanner).getIntInRangeFromUser(min, max);
        assert expected == actual : String.format("Expected %s, got %s", expected, actual);
    }
}