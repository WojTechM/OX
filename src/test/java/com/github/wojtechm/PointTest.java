package com.github.wojtechm;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Random;

/**
 * @author Makiela Wojciech
 */
public class PointTest {

    @DataProvider
    private static Object[][] dataForPointEquals() {

        Object[][] testCases = new Object[50][4];
        Random random = new Random();
        for (Object[] testCase : testCases) {
            int x = random.nextInt(20000);
            int y = random.nextInt(20000);
            testCase[0] = x;
            testCase[1] = y;
            testCase[2] = new Point(x, y);
            testCase[3] = true;

            // sometimes expect equals to return false
            if (random.nextBoolean()) {
                testCase[0] = x + 1 + random.nextInt(2000);
                testCase[3] = false;
            }
        }
        return testCases;
    }

    @Test(dataProvider = "dataForPointEquals")
    private void should_returnTrue_When_PointsAreEquals_Otherwise_returnFalse(int x, int y, Point toCompare, boolean expected) {
        Point point = new Point(x, y);
        boolean actual = point.equals(toCompare);
        assert expected == actual : String.format("\nCompared points using equals: \nP1{%s} \nP2{%s} \nExpected %s, got %s", point, toCompare, expected, actual);
    }

    @Test
    private void should_StoreVariablesAsFinal() throws NoSuchFieldException {
        Field field1 = Point.class.getDeclaredField("x");
        Field field2 = Point.class.getDeclaredField("y");
        assert Modifier.isFinal(field1.getModifiers()) : "'x' variable in Point class should be declared final";
        assert Modifier.isFinal(field2.getModifiers()) : "'y' variable in Point class should be declared final";
    }


}