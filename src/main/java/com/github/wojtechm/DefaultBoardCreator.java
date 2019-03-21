package com.github.wojtechm;

import com.github.wojtechm.settings.Settings;

/**
 * @author Makiela Wojciech
 */
public class DefaultBoardCreator implements BoardCreator {

    @Override
    public Board createBoard() {
        int width = Integer.parseInt(Settings.getInstance().getGameParameter("boardWidth"));
        int height = Integer.parseInt(Settings.getInstance().getGameParameter("boardHeight"));
        Field[][] fields = new Field[width][height];
        return new Board(fields);
    }
}
