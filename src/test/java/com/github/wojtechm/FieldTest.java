package com.github.wojtechm;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author Makiela Wojciech
 */
public class FieldTest {

    @Test
    private void Should_CreateFieldWithGivenParameter() {
        Character type1 = 'T';
        Field<Character> field1 = new Field<>(type1);
        assert type1 == field1.getRepresentation();

        Image type2 = new BufferedImage(32, 32, 1);
        Field<Image> field2 = new Field<>(type2);
        assert type2 == field2.getRepresentation();
    }

    @DataProvider
    private static Object[][] equalsReturnTrueTestData() {
        return new Object[][]{
                {new Field<>('X'), new Field<>('X')},
                {new Field<>('x'), new Field<>('x')},
                {new Field<>(""), new Field<>("")},
                {new Field<>(null), new Field<>(null)},
                {new Field<>(3), new Field<>(3)},
                {new Field<>(1.1), new Field<>(1.1)},
        };
    }


    @Test(dataProvider = "equalsReturnTrueTestData")
    private void Should_returnTrue_When_FieldsHaveSameContent(Field field, Field field2) {
        assert field.equals(field2);
    }

    @DataProvider
    private static Object[][] equalsReturnFalseTestData() {
        return new Object[][]{
                {new Field<>('X'), new Field<>('x')},
                {new Field<>('x'), new Field<>('X')},
                {new Field<>(""), new Field<>("string")},
                {new Field<>(null), new Field<>(new Object())},
                {new Field<>(3), new Field<>(4)},
                {new Field<>(1.1), new Field<>(1.2)},
                {new Field<>('O'), null},
                {new Field<>('O'), "string"},
                {new Field<>('O'), new Object()},
        };
    }

    @Test(dataProvider = "equalsReturnFalseTestData")
    private void Should_returnFalse_When_AreDifferentTypesOrFieldsHaveDifferentContent(Field field, Object object) {
        assert !field.equals(object);
    }

}
