import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Zipper {
    public static void main(String[] args) {

        Stream<Integer> firstStream = Stream.of(1, 3, 5, 7, 9, 11);
        Stream<Integer> secondStream = Stream.of(2, 4, 6, 8, 10);

        Stream<Integer> zipped = zip(firstStream, secondStream);
        zipped.forEach(System.out::println);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T> firstList = first.toList();
        List<T> secondList = second.toList();

        int size = Math.min(firstList.size(), secondList.size());

        return IntStream.range(0, size)
                .boxed()
                .flatMap(i -> Stream.of(firstList.get(i), secondList.get(i)));
    }
}
