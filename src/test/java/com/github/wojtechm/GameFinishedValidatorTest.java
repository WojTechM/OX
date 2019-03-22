package com.github.wojtechm;

import com.github.wojtechm.settings.DefaultSettingsUpdate;
import com.github.wojtechm.settings.SettingsUpdate;
import org.testng.annotations.Test;

/**
 * @author Makiela Wojciech
 */
public class GameFinishedValidatorTest {

    @Test
    void should_returnTrue_When_moveIsWinning() {
        // arrange
        SettingsUpdate settingsUpdate = new DefaultSettingsUpdate(null);
        settingsUpdate.updateGameParameter("boardWidth", "3");
        settingsUpdate.updateGameParameter("boardHeight", "3");
        settingsUpdate.updateGameParameter("inlineMatches", "3");
        settingsUpdate.updateGameParameter("numberOfRounds", "1");
        Field<String> x = new Field<>("x");
        Field[][] fields = new Field[][]{
                {x, null, null},
                {null, x, null},
                {null, null, x},
        };
        Board board = new Board(fields);
        GameFinishedValidator validator = new GameFinishedValidator();
        Move move = new Move(x, new Point(2, 2));
        // act
        boolean actual = validator.isMoveWinning(board, move);
        // assert
        assert actual : "Expected true";
    }
}