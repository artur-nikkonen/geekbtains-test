package ru.geekbrains.main.site.at.junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BeforeAndAfterAnnotationsTest {

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("BeforeAll");
    }

    @BeforeEach
    public void beforeEachTests() {
        System.out.println("BeforeEach");
    }

    @Test
    public void test01() {
        System.out.println("test01");
        assertTrue(true);
    }

    @Test
    public void test02() {
        System.out.println("test02");
        assertTrue(true);
    }

    @AfterEach
    public void afterEachTests() {
        System.out.println("AfterEach");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("AfterAll");
    }
}
