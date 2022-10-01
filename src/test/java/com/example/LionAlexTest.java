package com.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class LionAlexTest {

    @Test

    public void getKittensShouldReturnZero() throws Exception {
        LionAlex lionAlex = new LionAlex();
        int alexKittens = lionAlex.getKittens();
        Assert.assertEquals(0, alexKittens);
    }

    @Test
    public void getFriendsShouldReturnList() throws Exception {
        LionAlex lionAlex = new LionAlex();
        List<String> friendList = lionAlex.getFriends();
        Assert.assertEquals(List.of("Зебра Марти", "Бегемотиха Глория", "Жираф Мелман"), friendList);
    }

    @Test
    public void getPlaceOfLivingShouldReturnPlace() throws Exception {
        LionAlex lionAlex = new LionAlex();
        Assert.assertEquals("Нью-Йоркский зоопарк", lionAlex.getPlaceOfLiving());
    }

}
