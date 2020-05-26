package ru.geekbrains.main.site.at.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParametrizedTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 10, -100, 0, 5, Integer.MAX_VALUE, Integer.MIN_VALUE})
    public void isPosivive(int x) {
        assertTrue(x > 0);
    }

    @ParameterizedTest
    @CsvSource({"1,2,3", "10,11,12", "-1,0,1"})
    public void isIncrementNumbers(int a, int b, int c) {
        assertEquals(a + 1, b);
        assertEquals(b + 1, c);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/ParametrizedTestData.csv")
    public void isIncrementNumbersFromFile(int a, int b, int c) {
        assertEquals(a + 1, b);
        assertEquals(b + 1, c);
    }

    @ParameterizedTest
    @MethodSource("stringsForTest")
    public void isShrterString(String str, int length) {
        assertTrue(str.length() < length);
    }

    public static Stream<Arguments> stringsForTest() {
       return Stream.of(
         Arguments.of("main", 5),
         Arguments.of("function", 100),
         Arguments.of("lambda", 7)
       );
    }
}
