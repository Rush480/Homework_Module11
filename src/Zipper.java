import java.util.*;
import java.util.stream.Stream;

public class Zipper {
    public static void main(String[] args) {
        //Напишіть метод public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) який "перемішує" елементи зі стрімів first та second,
        // зупиняючись тоді, коли у одного зі стрімів закінчаться елементи.
        Stream<Integer> firstStream = Stream.of(1, 3, 5, 7, 9);
        Stream<Integer> secondStream = Stream.of(2, 4, 6, 8, 10);

        Stream<Integer> zipped = zip(firstStream,secondStream);
        zipped.forEach(System.out::println);

    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();

        Stream.Builder<T> builder = Stream.builder();
        while (firstIterator.hasNext() || secondIterator.hasNext()) {
            if (firstIterator.hasNext()) {
                builder.add(firstIterator.next());
            }
            if (secondIterator.hasNext()) {
                builder.add(secondIterator.next());
            }
        }

        return builder.build();
    }
}


