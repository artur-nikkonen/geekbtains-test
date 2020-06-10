package examples.exceptions;

import java.util.Arrays;
import java.util.Collection;
import java.util.OptionalInt;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamExamples {
    public static void main(String[] args) {
        //https://www.baeldung.com/java-8-streams

        Stream<String> emptyStream = Stream.empty();

        Collection<String> collection = Arrays.asList("q", "w", "e");
        Stream<String> streamOfCollection = collection.stream();

        Stream<String> streamOfArray = Stream.of("q", "w", "e");

        String[] arr = new String[]{"q", "w", "e"};
        Stream<String> streamOfArrayFull = Arrays.stream(arr);
        Stream<String> streamOfStringPart = Arrays.stream(arr, 1, 2);

        Stream<String> streamBuilder = Stream.<String>builder().add("q").add("w").build();

        Stream<String> streamGenerated = Stream.generate(() -> "qqq").limit(10);
        Stream<Integer> streamIterated = Stream.iterate(2, x -> x + 1).limit(20);

        //-------------------------------------------
        IntStream intStream = IntStream.range(1, 10);
        LongStream longStream = LongStream.rangeClosed(1, 10);
        DoubleStream doubleStream = new Random().doubles(20);

        IntStream charsStream = "qwert".chars();

        Stream<String> stringStream = Pattern.compile(", ").splitAsStream("a, b, c");

        OptionalInt reduced = IntStream.range(1, 4).reduce((a, b) -> a + b);

        System.out.println();

        // to be continued...
    }


}
