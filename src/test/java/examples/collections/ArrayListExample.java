package examples.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayListExample {

    public static void main(String[] args) {
        ArrayList<Man> list = new ArrayList<>();

        System.out.println("Список пустой: " + list.isEmpty());

        //добавляем элементы
        list.add(new Man(1, "Lena", 40));
        list.addAll(Arrays.asList(
                new Man(2, "Ira", 40),
                new Man(3, "Igor", 35),
                new Man(4, "Pasha", 12)));

        //выводим список
        list.forEach((x) -> {
            System.out.print(x + " ");
        });
        System.out.println();

        for (Man man : list) {
            System.out.print(man + " ");
        }
        System.out.println();

        System.out.println(list.toString());

        //создаем второй список
        ArrayList<Man> list2 = (ArrayList<Man>) list.clone();

        //сравниваем
        System.out.println("Сравнение списков: " + list.equals(list2));

        ArrayList<Man> list3 = new ArrayList<>();

        list3.addAll(Arrays.asList(
                new Man(2, "Ira", 40),
                new Man(4, "Pasha", 12),
                new Man(3, "Igor", 35)));

        //удаляем элементы
        list3.remove(0);
        list.retainAll(list3);

        System.out.println("list: " + list);
        System.out.println("list2: " + list2);
        System.out.println("list3: " + list3);

        //в массив
        Man[] mans = (Man[]) list2.toArray(new Man[list2.size()]);

        for (Man m : mans) {
            System.out.print(m + ", ");
        }
        System.out.println();

        System.out.println("Итератор");

        Iterator<Man> iterator = list2.iterator();

        while (iterator.hasNext()) {
            Man m = iterator.next();
            System.out.print(m + " ");
        }
        System.out.println();
    }
}
