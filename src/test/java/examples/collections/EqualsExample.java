package examples.collections;

import java.util.Objects;

public class EqualsExample {

    public static void main(String[] args) {
        Man man1 = new Man(1, "Ivan", 12);
        Man man2 = new Man(1, "Ivan", 12);

        System.out.println(man1.equals(man2));
        System.out.println(man1.hashCode());
        System.out.println(man2.hashCode());
    }
}

