package com.github.wojtechm;

import com.github.wojtechm.settings.DefaultSettingsUpdate;
import com.github.wojtechm.settings.SettingsUpdate;
import io.github.sskorol.core.DataSupplier;
import org.testng.annotations.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Makiela Wojciech
 */
public class DefaultBoardCreatorTest {

    @DataSupplier
    public Stream<int[]> boardSizeData() {
        return IntStream.rangeClosed(1, 50).mapToObj(n -> new int[] {n * 2, n + 17});
    }

    @Test(dataProvider = "boardSizeData")
    public void should_returnBoardWithValidSize_When_changedSettings(int[] size) {
        // arrange
        int width = size[0];
        int height = size[1];
        SettingsUpdate settingsUpdate = new DefaultSettingsUpdate(null);
        settingsUpdate.updateGameParameter("boardWidth", String.valueOf(width));
        settingsUpdate.updateGameParameter("boardHeight", String.valueOf(height));
        BoardCreator boardCreator = new DefaultBoardCreator();

        // act
        Board board = boardCreator.createBoard();

        // assert
        assert board.getWidth() == width && board.getHeight() == height;
    }
}