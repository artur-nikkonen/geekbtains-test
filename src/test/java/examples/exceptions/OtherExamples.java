package examples.exceptions;

public class OtherExamples {
    public static void main(String[] args) {
        multipleCatchAndFinally();
        trowExample();
        trowExample2();

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

    public static void trowExample() {
        try {
            Division(1, 2);
            Division(1, 0);
        } catch (ArithmeticException ex) {
            System.out.println("Catch ArithmeticException in trowExample()");
        }
    }

    public static void trowExample2() {

        //Я только не понял, почему Idea Не подчекивает этот вызов, хотя у функции явно прописано throws.
        //То есть если я не посмотрю в реализацию функции, то я никак это не узнаю про исключения. Даже подсказок нет.
        //Это какая-то дискриминация unchecked exceptions
        //В случае checked exceptions всё подчеркивается.)))

        Division(1, 0);
    }

    private static double Division(int a, int b) throws ArithmeticException {
        try {
            return a / b;
        } catch (ArithmeticException ex) {
            System.out.println("Catch ArithmeticException in Divide()");
            throw ex;
        }
    }
}
