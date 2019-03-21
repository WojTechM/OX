package com.github.wojtechm;

/**
 * @author Makiela Wojciech
 */
public interface PlayerCreator {
    /**
     * @return collection of Player objects (0.. n) wrapped in Players object
     * @throws GameInterruptedByUserException when user decided to quit creation midway through
     */
    Players createPlayers() throws GameInterruptedByUserException;
}
