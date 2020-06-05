package examples.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckedExceptionsExamples {
    public static void main(String[] args) {
        fileNotFoundExample();

        try {
            fileNotFoundExample2();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void fileNotFoundExample() {
        File file = new File("path");
        try {
            FileReader reader = new FileReader(file);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void fileNotFoundExample2() throws FileNotFoundException {
        File file = new File("path");
        FileReader reader = new FileReader(file);
    }
}
