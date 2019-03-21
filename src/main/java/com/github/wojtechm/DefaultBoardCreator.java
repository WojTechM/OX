package com.github.wojtechm;

import com.github.wojtechm.settings.Settings;

/**
 * BoardCreator using data provided by Settings class {@link com.github.wojtechm.settings.Settings}
 * @author Makiela Wojciech
 */
public class DefaultBoardCreator implements BoardCreator {

    /**
     * @return new Board object created in accordance to Settings {@link com.github.wojtechm.settings.Settings}
     */
    @Override
    public Board createBoard() {
        int width = Integer.parseInt(Settings.getInstance().getGameParameter("boardWidth"));
        int height = Integer.parseInt(Settings.getInstance().getGameParameter("boardHeight"));
        Field[][] fields = new Field[width][height];
        return new Board(fields);
    }
}
