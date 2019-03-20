package com.github.wojtechm;

/**
 * @author Makiela Wojciech
 */
public class ConsoleBoardCreator implements BoardCreator {

    private ConsoleInputAcquirer inputAcquirer;

    @Override
    public Board createBoard() {
        Field[][] fields = new Field[][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
        };
        return new Board(fields);
    }
}
