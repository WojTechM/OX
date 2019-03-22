package com.github.wojtechm;

import org.testng.annotations.Test;

import java.util.Random;

/**
 * @author Makiela Wojciech
 */
public class PlayersTest {

    @Test
    private void should_ReturnActivePlayer_When_CalledGetCurrentPlayer() {
        Player p1 = new Player(null, null);
        Player p2 = new Player(null, null);
        Players players = new Players(p1, p2);
        assert p1 == players.getCurrentPlayer();
    }


    @Test
    private void should_SwichActivePlayer_When_CalledMoveToNextPlayer() {
        Player p1 = new Player(null, null);
        Player p2 = new Player(null, null);
        Players players = new Players(p1, p2);
        players.moveToNextPlayer();
        assert p2 == players.getCurrentPlayer();
    }


    @Test
    private void should_SetActivePlayer_When_CalledSetPlayerAsCurrent() {
        Player p1 = new Player(null, null);
        Player p2 = new Player(null, null);
        Players players = new Players(p1, p1, p1, p2, p1);
        players.setPlayerAsCurrent(p2);
        assert p2 == players.getCurrentPlayer();
    }


    @Test(expectedExceptions = IllegalArgumentException.class)
    private void should_ThrowException_When_TriedToSetNonexistentPlayerAsCurrent() {
        Player p1 = new Player(null, null);
        Player p2 = new Player(null, null);
        Players players = new Players(p1, p2);
        Player nonexistent = new Player(null, null);
        players.setPlayerAsCurrent(nonexistent);
    }

    @Test
    private void should_KeepLooping_When_UpdatingCurrentPlayerIndex() {
        Player p1 = new Player(null, null);
        Player p2 = new Player(null, null);
        Players players = new Players(p1, p2);
        for (int n = 0; n < 10; n++) players.moveToNextPlayer();
        assert p1 == players.getCurrentPlayer();
    }

}