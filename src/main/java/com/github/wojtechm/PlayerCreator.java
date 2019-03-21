package com.github.wojtechm;

/**
 * @author Makiela Wojciech
 */
public interface PlayerCreator {
    Players createPlayers() throws GameInterruptedByUserException;
}
