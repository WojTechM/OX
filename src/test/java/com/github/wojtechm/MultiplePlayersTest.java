package com.github.wojtechm;

import com.github.wojtechm.settings.DefaultSettingsUpdate;
import com.github.wojtechm.settings.SettingsUpdate;
import com.github.wojtechm.settings.TranslationLoader;
import org.testng.annotations.Test;

import java.util.Scanner;

/**
 * @author Makiela Wojciech
 */
public class MultiplePlayersTest {


    @Test
    void should_endWithPlayer1Win_When_playingWith7Players() {
        // arrange
        SettingsUpdate settingsUpdate = new DefaultSettingsUpdate(null);
        settingsUpdate.updateGameParameter("boardWidth", "13");
        settingsUpdate.updateGameParameter("boardHeight", "20");
        settingsUpdate.updateGameParameter("inlineMatches", "7");
        settingsUpdate.updateGameParameter("numberOfRounds", "1");
        StringBuilder sb = new StringBuilder("1\ndefaultOrder\n");
        for (int n = 0; n < 7 * 13; n++) {
            int x = n % 13 + 1;
            int y = Math.floorDiv(n, 13) + 1;
            sb.append(x);
            sb.append("\n");
            sb.append(y);
            sb.append("\n");
        }
        sb.append(3);
        String log = sb.toString();
        ConsoleInputAcquirer acquirer = new ConsoleInputAcquirer(new Scanner(log));
        Player p1 = new Player(new Field<>('A'), new Score(0));
        Player p2 = new Player(new Field<>('B'), new Score(0));
        Player p3 = new Player(new Field<>('C'), new Score(0));
        Player p4 = new Player(new Field<>('D'), new Score(0));
        Player p5 = new Player(new Field<>('E'), new Score(0));
        Player p6 = new Player(new Field<>('F'), new Score(0));
        Player p7 = new Player(new Field<>('G'), new Score(0));
        Players players = new Players(p1, p2, p3, p4, p5, p6, p7);
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
        assert p1.points() == 3: "Expected Player1Winning.";
    }
}
