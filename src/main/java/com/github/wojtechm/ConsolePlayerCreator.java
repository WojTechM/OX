package com.github.wojtechm;

/**
 * @author Makiela Wojciech
 */
class ConsolePlayerCreator implements PlayerCreator {

    private ConsoleInputAcquirer inputAcquirer;

    @Override
    public Players createPlayers() {
        return new Players(new Player(new Field<>('o'), new Score(0)), new Player(new Field<>('x'), new Score(0)));
    }
}
