package com.github.wojtechm;

import java.util.Arrays;
import java.util.List;

/**
 * @author Makiela Wojciech
 */
class Players {

    private List<Player> players;
    private int currentPlayerIndex = 0;

    Players(Player... players) {
        this.players = Arrays.asList(players);
    }


    Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    void moveToNextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    void setPlayerAsCurrent(Player player) {
        int index = players.indexOf(player);
        if (index == -1) {
            throw new IllegalArgumentException("Passed player is not part of this game.");
        }
        currentPlayerIndex = index;
    }

    void setPlayerAsCurrent(String symbol) {
        for (int index = 0; index < players.size(); index++) {
            if (players.get(index).mark.toString().equals(symbol)) {
                currentPlayerIndex = index;
            }
        }
    }
    void givePoints(int n) {
        players.forEach(player -> player.addPoints(n));
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Player p : players) {
            builder.append(p.mark);
            builder.append(":");
            builder.append(p.points());
            builder.append("  ");
        }
        return builder.toString();
    }
}
