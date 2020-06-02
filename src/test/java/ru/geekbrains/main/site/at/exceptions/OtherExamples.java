package ru.geekbrains.main.site.at.exceptions;

public class OtherExamples {
    public static void main(String[] args) {
        multipleCatchAndFinally();
        trowExample();

    }

    public static void multipleCatchAndFinally() {
        try {

            makeSomething("qaz");

        } catch (ArrayIndexOutOfBoundsException | ArrayStoreException ex) {
            System.out.println("Catch 1. " + ex.getClass().getName() + " " + ex.getMessage());
        } catch (NumberFormatException ex) {
            System.out.println("Catch 2. " + ex.getClass().getName() + " " + ex.getMessage());
        } finally {
            System.out.println("I'm finally block");
        }
    }

    private static void makeSomething(String str) {
        int i = Integer.parseInt(str);
        Object x[] = new String[3];
        x[0] = i;
    }

    public static void trowExample(){
        try {
            Division(1, 2);
            Division(1, 0);
        }catch (ArithmeticException ex){
            System.out.println("Catch ArithmeticException in trowExample()");
        }

    }

    private static double Division(int a, int b) throws ArithmeticException{
        try {
            return a / b;
        }catch (ArithmeticException ex){
            System.out.println("Catch ArithmeticException in Divide()");
            throw ex;
        }
    }
}
