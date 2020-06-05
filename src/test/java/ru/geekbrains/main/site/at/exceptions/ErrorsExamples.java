package ru.geekbrains.main.site.at.exceptions;

import java.util.ArrayList;

public class ErrorsExamples {

    public static void main(String[] args) {
        //Подсчет предельной глубины рекурсии
        //при повторе предельная глубина увеличивается
        System.out.println("StackOverflowError. Глубина стека: " + calcDepth(0));
        System.out.println("StackOverflowError. Глубина стека (повтор 1): " + calcDepth(0));
        System.out.println("StackOverflowError. Глубина стека (повтор 2): " + calcDepth(0));

        //подсчет глубины рекурсии с переменной в теле метода
        System.out.println("StackOverflowError. Глубина стека юез переменной: " + calcDepth(0));
        System.out.println("StackOverflowError. Глубина стека с 1 переменной int: " + calcDepthInt1(0));
        System.out.println("StackOverflowError. Глубина стека с 1 переменной int: " + calcDepthInt1(0));
        System.out.println("StackOverflowError. Глубина стека с 2 переменными int: " + calcDepthInt2(0));
        System.out.println("StackOverflowError. Глубина стека с 2 переменными int: " + calcDepthInt2(0));

        //Вывод: интересно но непредсказуемо)))

        System.out.println("OutOfMemoryError. Было выделено: " + calcMaxMemory() * 4 + " байт");
    }

    private static int calcDepth(int i) {
        try {
            return calcDepth(i + 1);
        } catch (StackOverflowError er) {
            return i;
        }
    }

    private static int calcDepthInt1(int i) {
        try {
            int a = 1;
            return calcDepthInt1(i + 1);
        } catch (StackOverflowError er) {
            return i;
        }
    }

    private static int calcDepthInt2(int i) {
        try {
            int a = 1;
            int b = 1;
            return calcDepthInt2(i + 1);
        } catch (StackOverflowError er) {
            return i;
        }
    }

    public static long calcMaxMemory() {
        long total = 0;
        int arrayLen = 1000000;

        ArrayList<int[]> list = new ArrayList<>();

        try {
            while (true) {
                list.add(new int[arrayLen]);
                total += arrayLen;
            }
        } catch (OutOfMemoryError er) {
        }

        return total;
    }

}
