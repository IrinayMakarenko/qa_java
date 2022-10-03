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
public class LionTestParameterized {
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    private final String sex;
    private final boolean haveManeResult;

    public LionTestParameterized(String sex, boolean haveManeResult) {
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
    Feline feline;

    @Test
    public void DoesHaveManeShouldReturnTrue() throws Exception {
        Lion lion = new Lion(sex, feline);
        Assert.assertEquals(haveManeResult, lion.doesHaveMane());
    }

    @Test
    public void testGetKittensShouldReturnKittens() throws Exception {
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getKittens()).thenReturn(10);
        Assert.assertEquals(10, lion.getKittens());
    }

    @Test
    public void GetFoodShouldReturnList() throws Exception {
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

}
