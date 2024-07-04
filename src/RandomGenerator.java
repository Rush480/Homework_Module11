import java.util.stream.Stream;

public class RandomGenerator {
    private long seed;

    public RandomGenerator(int seed) {
        this.seed = seed;
    }

    public Stream<Long> generateRandomNum(long a, long c, long m) {
        return Stream.iterate(seed, n -> (a * n + c) % m);
    }
}

class GeneratorTest {
    public static void main(String[] args) {

        RandomGenerator gen = new RandomGenerator(3);

        long a = 25214903917L;
        long c = 11;
        long m = (long) Math.pow(2, 48);

        Stream<Long> randomNumbs = gen.generateRandomNum(a, c, m);
        randomNumbs.forEach(System.out::println);
    }
}