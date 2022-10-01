package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    private final String sex;
    private final boolean haveManeResult;

    public LionTest(String sex, boolean haveManeResult) {
        this.sex = sex;
        this.haveManeResult = haveManeResult;
    }

    @Parameterized.Parameters
    public static Object[][] getLionSex() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Mock
    Predator predator;

    @Test
    public void testGetKittensShouldReturnKittens() {
        Lion lion = new Lion(predator);
        Mockito.when(predator.getKittens()).thenReturn(10);
        Assert.assertEquals(10, lion.getKittens());
    }

    @Test
    public void DoesHaveManeShouldReturnTrue() throws Exception {
        Lion lion = new Lion(sex);
        Assert.assertEquals(haveManeResult, lion.doesHaveMane());
    }

    @Test
    public void DoesHaveManeShouldThrowsException() throws Exception {
        Exception exception = Assert.assertThrows(Exception.class, () -> {
            new Lion("Нечто");
        });
        Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    public void DoesHaveManeShouldReturnFalseForPredator() {
        Lion lion = new Lion(predator);
        Assert.assertEquals(false, lion.doesHaveMane());
    }

    @Test
    public void GetFoodShouldReturnList() throws Exception {
        Lion lion = new Lion(predator);
        Mockito.when(predator.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }
}