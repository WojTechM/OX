package com.github.wojtechm;

import com.github.wojtechm.logger.Logger;
import com.github.wojtechm.settings.DefaultSettingsUpdate;
import com.github.wojtechm.settings.Settings;
import com.github.wojtechm.settings.TranslationLoader;

import java.io.*;
import java.util.Scanner;

/**
 * @author Makiela Wojciech
 */
public class Main {

    public static void main(String[] args) {

        Settings.getInstance().setTranslation(new TranslationLoader().loadTranslation("polski"));

        ConsoleInputAcquirer acquirer = getInputAcquirer(args);

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

    private static ConsoleInputAcquirer getInputAcquirer(String[] args) {
        if (args.length >= 1) {
            try {
                String fileAsString = getRequestedFileContent(args[0]);
                return new ConsoleInputAcquirer(new Scanner(fileAsString));
            } catch (IOException e) {
                Logger.getInstance().display(Settings.getInstance().getMessage("invalidFile"));
            }
        }
        return new ConsoleInputAcquirer(new Scanner(System.in));
    }

    private static String getRequestedFileContent(String file) throws IOException {
        InputStream is = new FileInputStream(file);
        BufferedReader buf = new BufferedReader(new InputStreamReader(is));

        String line = buf.readLine();
        StringBuilder sb = new StringBuilder();

        while (line != null) {
            sb.append(line).append("\n");
            line = buf.readLine();
        }

        return sb.toString();
    }
}
