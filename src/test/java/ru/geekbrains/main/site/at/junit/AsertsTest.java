package ru.geekbrains.main.site.at.junit;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class AsertsTest {
    @Test
    public void allAsserts() {

        int a = 1;
        assertEquals(1, a);

        assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3});

        assertTrue(1 == 1);

        String str1 = null;
        String str2 = "qwert";
        assertNull(str1);
        assertNotNull(str2);

        assertThrows(ArithmeticException.class, () -> {
            int x = 100 / 0;
        });

        assertTimeout(Duration.ofSeconds(1), ()->{
            Thread.sleep(900);
        });

        assertAll(
                () -> assertNull(str1),
                () -> assertNotNull(str2),
                () -> assertTrue(1 == 1)
        );
    }
}
