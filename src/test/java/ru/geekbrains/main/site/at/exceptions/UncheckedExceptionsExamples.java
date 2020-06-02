package ru.geekbrains.main.site.at.exceptions;

import java.awt.*;
import java.io.File;
import java.io.FileReader;

public class UncheckedExceptionsExamples {

    public static void main(String[] args) {
        arithmeticExceptionExample();
        arrayIndexOutOfBoundsExceptionExample();
        arrayStoreExceptionExample();
        classCastExceptionExample();
        illegalArgumentExceptionExample();
        indexOutOfBoundsExceptionExample();
        negativeArraySizeExceptionExample();
        nullPointerExceptionExample();
        numberFormatExceptionExample();
    }

    public static void arithmeticExceptionExample() {
        try {
            int i = 0;
            int j = 100 / i;
        } catch (ArithmeticException ex) {
            System.out.println(ex.getClass().getName() + " " + ex.getMessage());
        }
    }

    public static void arrayIndexOutOfBoundsExceptionExample() {
        try {
            int[] mas = new int[]{1, 2, 3, 4, 5};
            int b = mas[100];
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex.getClass().getName() + " " + ex.getMessage());
        }
    }

    public static void arrayStoreExceptionExample() {
        try {
            Object x[] = new String[3];
            x[0] = 0;

        } catch (ArrayStoreException ex) {
            System.out.println(ex.getClass().getName() + " " + ex.getMessage());
        }
    }

    public static void classCastExceptionExample() {
        try {
            Object str = "qwert";
            int i = (int) str;

        } catch (ClassCastException ex) {
            System.out.println(ex.getClass().getName() + " " + ex.getMessage());
        }
    }

    public static void illegalArgumentExceptionExample() {
        try {
            byte a = intToByte(500);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getClass().getName() + " " + ex.getMessage());
        }
    }

    private static byte intToByte(int i) throws IllegalArgumentException {
        if (0 <= i && i <= 255) {
            return (byte) i;
        } else {
            throw new IllegalArgumentException("Bad byte " + i);
        }
    }

    public static void indexOutOfBoundsExceptionExample() {
        try {
            String str = "qwert";
            String str2 = str.substring(100);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.getClass().getName() + " " + ex.getMessage());
        }
    }

    public static void negativeArraySizeExceptionExample() {
        try {
            int a = 10;
            int b = 20;
            int size = a - b;
            int[] i = new int[size];
        } catch (NegativeArraySizeException ex) {
            System.out.println(ex.getClass().getName() + " " + ex.getMessage());
        }
    }

    public static void nullPointerExceptionExample(){
        try {
            Point p = null;
            int x = p.x;
        } catch (NullPointerException ex) {
            System.out.println(ex.getClass().getName() + " " + ex.getMessage());
        }
    }

    public static void numberFormatExceptionExample(){
        try {
            String str = "100.0.0";
            Double d = Double.parseDouble(str);
        } catch (NumberFormatException ex) {
            System.out.println(ex.getClass().getName() + " " + ex.getMessage());
        }

        try {
            String str = "100.0A";
            Double d = Double.parseDouble(str);
        } catch (NumberFormatException ex) {
            System.out.println(ex.getClass().getName() + " " + ex.getMessage());
        }
    }
}


