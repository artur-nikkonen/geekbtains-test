package ru.geekbrains.main.site.at.junit;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcreastTest {

    @Test
    public void hamcrestTest01() {
        int a = 1;
        assertThat(a, equalTo(1));
        assertThat(a, is(equalTo(1)));

        String str1 = "qwert";
        assertThat(str1, notNullValue());

        Object obj1 = new Object();
        Object obj2 = obj1;
        assertThat(obj1, sameInstance(obj2));

        assertThat(10, greaterThan(8));
        assertThat(10, lessThanOrEqualTo(10));
        assertThat(10.0, closeTo(9.0, 2.0));

        assertThat("Hello", equalToIgnoringCase("HELLO"));
        assertThat("Hello, world!!!", containsString("world"));
        assertThat("Hello, world!!!", endsWith("!!!"));
        assertThat("   Hello,   world!!!   ", equalToCompressingWhiteSpace("Hello, world!!!"));

        Integer x = 0;
        assertThat(x, instanceOf(Number.class));
    }

    @Test
    public void hamcrestTest02() {

        assertThat(10, allOf(
                equalTo(10),
                lessThanOrEqualTo(100)
        ));

        assertThat(10, anyOf(
                equalTo(6),
                lessThanOrEqualTo(100)
        ));

        assertThat(10, not(allOf(
                equalTo(10),
                lessThanOrEqualTo(6)
        )));



    }
}
