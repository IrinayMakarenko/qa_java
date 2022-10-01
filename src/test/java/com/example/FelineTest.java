package com.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FelineTest {

    @Test

    public void eatMeatShouldReturnAnimalKind() throws Exception {
        Feline feline = new Feline();
        List<String> result = feline.eatMeat();
        Assert.assertEquals(feline.getFood("Хищник"), result);
    }

    @Test
    public void getFamilyShouldFeline() {
        Feline feline = new Feline();
        String result = feline.getFamily();
        Assert.assertEquals("Кошачьи", result);
    }

    @Test
    public void getKittensCountWithoutParameter() {
        Feline feline = new Feline();
        int kittensCount = feline.getKittens();
        Assert.assertEquals(1, kittensCount);
    }

    @Test
    public void getKittensCountWithParameter() {
        Feline feline = new Feline();
        int kittensCount = feline.getKittens(12);
        Assert.assertEquals(12, kittensCount);
    }
}