import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Homework11 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Adam");
        names.add("Brock");
        names.add("Clade");
        names.add("Dorian");
        names.add("Evan");
        names.add("Felix");

        System.out.println(oddIndexedNames(names));

        System.out.println(sortedAndUpperCase(names));


        String[] digits = {"1, 2, 0", "4, 5"};

        sortedDigitsArray(digits);

    }

    // Task 1
    private static String oddIndexedNames(List<String> names) {
        return IntStream.range(0, names.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(index -> (index + 1) + ". " + names.get(index))
                .collect(Collectors.joining(", "));
    }


    // Task 2
    private static List<String> sortedAndUpperCase(List<String> names) {
        return names.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .toList();
    }


    // Task 3
    private static void sortedDigitsArray(String[] digits) {
        String result = Arrays.stream(digits)
                .flatMap(s -> Arrays.stream(s.split(", ")))
                .map(Integer::parseInt)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(result);
    }

}
