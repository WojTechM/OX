package com.github.wojtechm;

import com.github.wojtechm.settings.DefaultSettingsUpdate;
import com.github.wojtechm.settings.Settings;
import com.github.wojtechm.settings.TranslationLoader;

import java.util.Scanner;

/**
 * @author Makiela Wojciech
 */
public class Main {

    public static void main(String[] args) {

        ConsoleInputAcquirer acquirer = new ConsoleInputAcquirer(new Scanner(System.in));

        Settings.getInstance().setTranslation(new TranslationLoader().loadTranslation("polski"));

        OxGame oxGame = new ConsoleOxGame(
                new DefaultSettingsUpdate(
                        new TranslationLoader()
                ),
                new ConsoleGameController(
                        new ConsolePlayerCreator(acquirer),
                        new DefaultBoardCreator(),
                        acquirer),
                acquirer);
        oxGame.run();

    }
}
