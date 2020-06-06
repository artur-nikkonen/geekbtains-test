package examples.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {
    //Аналогично ArrayList
    public static void main(String[] args) {
        HashSet<Man> set = new HashSet<>();

        System.out.println("Set пустой: " + set.isEmpty());

        //добавляем элементы
        set.add(new Man(1, "Lena", 40));
        set.add(new Man(1, "Lena", 40));
        set.add(new Man(1, "Lena", 40));
        set.addAll(Arrays.asList(
                new Man(1, "Lena", 40),
                new Man(2, "Ira", 40),
                new Man(3, "Igor", 35),
                new Man(4, "Pasha", 12)));

        //выводим список
        set.forEach((x) -> {
            System.out.print(x + " ");
        });
        System.out.println();

        for (Man man : set) {
            System.out.print(man + " ");
        }
        System.out.println();

        System.out.println(set.toString());

        //создаем второй список
        HashSet<Man> set2 = (HashSet<Man>) set.clone();

        //сравниваем
        System.out.println("Сравнение списков: " + set.equals(set2));

        HashSet<Man> set3 = new HashSet<>();

        set3.addAll(Arrays.asList(
                new Man(2, "Ira", 40),
                new Man(2, "Ira", 40),
                new Man(2, "Ira", 40),
                new Man(4, "Pasha", 12),
                new Man(3, "Igor", 35)));

        //удаляем элементы
        System.out.println("set3 before delete first element: " + set3);
        set3.remove(set3.iterator().next());
        System.out.println("set3 after delete first element: " + set3);

        set.retainAll(set3);

        System.out.println("set: " + set);
        System.out.println("set2: " + set2);
        System.out.println("set3: " + set3);

        //в массив
        Man[] mans = (Man[]) set2.toArray(new Man[set2.size()]);

        for (Man m : mans) {
            System.out.print(m + ", ");
        }
        System.out.println();

        System.out.println("Итератор");

        Iterator<Man> iterator = set2.iterator();

        while (iterator.hasNext()) {
            Man m = iterator.next();
            System.out.print(m + " ");
        }
        System.out.println();
    }
}
