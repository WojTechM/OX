package com.github.wojtechm;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.function.Predicate;

/**
 * @author Makiela Wojciech
 */
public class ScoreTest {

    @Test
    private void should_CreateFieldWithGivenParameter() {
        Score score = new Score(0);
        assert score.points == 0;
        score = new Score(7);
        assert score.points == 7;
    }

    @DataProvider
    private static Object[][] dataForEqualsTest() {
        return new Object[][]{
                {new Score(0), new Score(0), true},
                {new Score(24), new Score(24), true},
                {new Score(99999), new Score(99999), true},
                {new Score(0), new Score(1), false},
                {new Score(1), new Score(2), false},
                {new Score(2), null, false},
                {new Score(3), "string", false},
                {new Score(4), new Object(), false},
        };
    }

    @Test(dataProvider = "dataForEqualsTest")
    private void should_ReturnCorrectBoolean_When_UsingEqualsMethod(Score score, Object object, boolean expected) {
        boolean actual = score.equals(object);
        assert expected == actual : String.format("Compared %s and %s. Expected %s, got %s", score, object, expected, actual);
    }

    @DataProvider
    private static Object[][] dataForEqualsHashCodeTest() {
        return new Object[][]{
                {new Score(0), new Score(0), true},
                {new Score(24), new Score(24), true},
                {new Score(99999), new Score(99999), true},
                {new Score(0), new Score(1), false},
                {new Score(1), new Score(2), false},

        };
    }

    @Test(dataProvider = "dataForEqualsHashCodeTest")
    private void should_ReturnEqualHashCode_When_ScoresAreEqual(Score score, Score score2, boolean expected) {
        boolean actual = score.hashCode() == score2.hashCode();
        assert expected == actual : String.format("Compared hashcodes of %s and %s. Expected %s, got %s", score, score2, expected, actual);
    }


    @DataProvider
    private static Object[][] dataForCompareToTests() {

        Predicate<Integer> isLessThan0 = n -> n < 0;
        Predicate<Integer> isMoreThan0 = n -> n > 0;
        Predicate<Integer> is0 = n -> n == 0;

        return new Object[][]{
                {new Score(0), new Score(0), is0},
                {new Score(24), new Score(24), is0},
                {new Score(99999), new Score(99999), is0},
                {new Score(0), new Score(1), isLessThan0},
                {new Score(1), new Score(2), isLessThan0},
                {new Score(-11), new Score(20), isLessThan0},
                {new Score(21), new Score(21), is0},
                {new Score(21), new Score(0), isMoreThan0},
                {new Score(999), new Score(100), isMoreThan0},
                {new Score(166), new Score(64), isMoreThan0},
                {new Score(21), new Score(-10), isMoreThan0},
        };
    }

    @Test(dataProvider = "dataForCompareToTests")
    private void should_ReturnIntInAccordanceToCompareToApi_When_CalledCompareTo(Score score, Score score2, Predicate<Integer> predicate) {
        boolean actual = predicate.test(score.compareTo(score2));
        assert actual : String.format("Compared Scores: %s and %s", score, score2);
    }

    @DataProvider
    private static Object[][] dataForIncreasePointsTest() {

        Object[][] testCases = new Object[50][3];
        Random random = new Random();
        for (Object[] testCase : testCases) {
            int base = random.nextInt(20000);
            int increase = random.nextInt(10000);
            testCase[0] = new Score(base);
            testCase[1] = increase;
            testCase[2] = new Score(base + increase);
        }
        return testCases;
    }

    @Test(dataProvider = "dataForIncreasePointsTest")
    private void should_ReturnNewScoreObjectWithIncreasedValue_When_CalledIncreasePoints(Score score, int increase, Score expected) {
        Score actual = score.increasePoints(increase);
        assert expected.equals(actual) : String.format("Increased %s by %s. Expected %s, got %s", score, increase, expected, actual);
    }

}