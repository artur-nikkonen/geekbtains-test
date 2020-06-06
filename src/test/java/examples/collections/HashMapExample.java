package examples.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<String, Man> phoneBook = new HashMap<>();

        System.out.println("Словарь пустой: " + phoneBook.isEmpty());
        phoneBook.put("+7(123)11-22-33", new Man(1, "Lena", 40));
        phoneBook.put("+7(123)12-22-33", new Man(2, "Ira", 40));
        phoneBook.put("+7(123)13-22-33", new Man(3, "Igor", 35));

        //выводим список
        phoneBook.forEach((phone, man) -> {
            System.out.print(phone + " " + man + "; ");
        });
        System.out.println();

        for (Map.Entry<String, Man> item : phoneBook.entrySet()) {
            System.out.print(item.getKey() + " " + (Man) item.getValue() + "; ");
        }
        System.out.println();

        System.out.println(phoneBook.toString());

        //поиск
        System.out.println("Содержит +7(123)13-22-33: " + phoneBook.containsKey("+7(123)13-22-33"));

        //все ключи
        Set<String> keys = phoneBook.keySet();
        System.out.println(keys);

        //значения
        Collection<Man> values = phoneBook.values();
        System.out.println(values);

        //удаление
        phoneBook.remove("+7(123)13-22-33");
        System.out.println(phoneBook.toString());

        System.out.println("Итератор");
    }
}
