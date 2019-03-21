package com.github.wojtechm;

import com.github.wojtechm.settings.DefaultSettingsUpdate;
import com.github.wojtechm.settings.SettingsUpdate;
import com.github.wojtechm.settings.TranslationLoader;
import org.testng.annotations.Test;

import java.util.Scanner;

/**
 * @author Makiela Wojciech
 */
public class EndToEndTests {

    @Test
    public void should_endWithDraw_When_quitBeforeEndOfFirstGame() {
        // arrange
        ConsoleInputAcquirer acquirer = new ConsoleInputAcquirer(new Scanner("invalid\ninputs\n1\n1\n1\n2\n2\n\n\n!koniec"));
        Player p1 = new Player(new Field<>('X'), new Score(0));
        Player p2 = new Player(new Field<>('O'), new Score(0));
        Players players = new Players(p1, p2);
        OxGame oxGame = new ConsoleOxGame(
                new DefaultSettingsUpdate(
                        new TranslationLoader()
                ),
                new ConsoleGameController(
                        new ConsolePlayerCreator(acquirer),
                        new DefaultBoardCreator(),
                        acquirer,
                        players),
                acquirer);
        // act
        oxGame.run();
        // assert
        assert p1.points() == 0 && p2.points() == 0 : "Expected draw.";
    }


    @Test
    public void should_endWithPlayer1Winning3to0_When_Player1WinsMatch() {
        // arrange
        SettingsUpdate settingsUpdate = new DefaultSettingsUpdate(null);
        settingsUpdate.updateGameParameter("boardWidth", "10");
        settingsUpdate.updateGameParameter("boardHeight", "78");
        settingsUpdate.updateGameParameter("inlineMatches", "4");
        settingsUpdate.updateGameParameter("numberOfRounds", "1");
        ConsoleInputAcquirer acquirer = new ConsoleInputAcquirer(new Scanner("startGame->\n1" +
                "\nP1Move->\n7\n65" +
                "\nP2Move->\n2\n2" +

                "\nP1Move->\n8\n66" +
                "\nP2Move->\n8\n65" +

                "\nP1Move->\n9\n67" +
                "\nP2Move->\n10\n68" +

                "\nP1Move->\n6\n64" +
                "\nExitGame->\n3"));
        Player p1 = new Player(new Field<>('X'), new Score(0));
        Player p2 = new Player(new Field<>('O'), new Score(0));
        Players players = new Players(p1, p2);
        OxGame oxGame = new ConsoleOxGame(
                new DefaultSettingsUpdate(
                        new TranslationLoader()
                ),
                new ConsoleGameController(
                        new ConsolePlayerCreator(acquirer),
                        new DefaultBoardCreator(),
                        acquirer,
                        players),
                acquirer);
        // act
        oxGame.run();
        // assert
        assert p1.points() == 3 && p2.points() == 0 : "Expected Player1Winning.";
    }
}
