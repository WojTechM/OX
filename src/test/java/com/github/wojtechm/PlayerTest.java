package com.github.wojtechm;

import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author Makiela Wojciech
 */
public class PlayerTest {

    @Test
    private void should_StoreVariablesAsFinal() throws NoSuchFieldException {
        Field field1 = Player.class.getDeclaredField("mark");
        Field field2 = Player.class.getDeclaredField("score");
        assert Modifier.isFinal(field1.getModifiers()) : "'mark' variable in Point class should be declared final";
        assert Modifier.isFinal(field2.getModifiers()) : "'score' variable in Point class should be declared final";
    }

    @Test
    private void should_PersistSentData() {
        com.github.wojtechm.Field<String> field = new com.github.wojtechm.Field<>("f");
        Score score = new Score(0);
        Player player = new Player(field, score);
        assert player.mark == field;
    }
}