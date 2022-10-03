package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionAlexTest {
    @Mock
    Feline feline;

    @Test

    public void getKittensShouldReturnZero() throws Exception {
        LionAlex lionAlex = new LionAlex(feline);
        int alexKittens = lionAlex.getKittens();
        Assert.assertEquals(0, alexKittens);
    }

    @Test
    public void getFriendsShouldReturnList() throws Exception {
        LionAlex lionAlex = new LionAlex(feline);
        List<String> friendList = lionAlex.getFriends();
        Assert.assertEquals(List.of("Зебра Марти", "Бегемотиха Глория", "Жираф Мелман"), friendList);
    }

    @Test
    public void getPlaceOfLivingShouldReturnPlace() throws Exception {
        LionAlex lionAlex = new LionAlex(feline);
        Assert.assertEquals("Нью-Йоркский зоопарк", lionAlex.getPlaceOfLiving());
    }

}
