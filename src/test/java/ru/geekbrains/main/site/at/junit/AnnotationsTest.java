package ru.geekbrains.main.site.at.junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
public class AnnotationsTest {

    //-------Просто тест-------
    @Test
    public void test() {
        assertTrue(true);
    }

    //-------Повторения-------
    @RepeatedTest(100)
    public void repeatedTest() {

        double x = Math.random();
        assertTrue(x > 0.5);
    }

    //-------Выводимое имя-------
    @Test
    @DisplayName("X меньше, чем Y")
    public void displayNameTest() {
        double x = 0;
        double y = 10;
        assertTrue(x < y);
    }

    //-------Timeout-------
    @Test
    @Timeout(2)
    public void timeoutTest1() throws InterruptedException {
        Thread.sleep(2100);
        int a = 10;
        assertEquals(10, a);
    }

    @Test
    @Timeout(2)
    public void timeoutTest2() throws InterruptedException {
        Thread.sleep(1900);
        int a = 10;
        assertEquals(10, a);
    }

    //-------Выключение теста-------
    @Disabled
    @Test
    public void disabledTest() {
        assertTrue(true);
    }

}
