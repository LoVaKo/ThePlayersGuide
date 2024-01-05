package BetterRandom;

import java.util.Random;

public class RandomUtils {
    private static final Random random = new Random();

    public static double nextDouble(double maxValue) {
        return random.nextDouble() * maxValue;
    }

    public static String nextString(String... strings) {
        if (strings.length == 0) return null;
        return strings[random.nextInt(strings.length)];
    }

    public static boolean coinFlip() {
        return coinFlip(0.5);
    }

    public static boolean coinFlip(double headsChance) {
        return random.nextDouble() < headsChance;
    }

    public static void main(String[] args) {
        System.out.println(coinFlip());
        System.out.println(coinFlip(0.9));
        System.out.println(nextDouble(50));
        System.out.println(nextString("Hello", "Goodbye", "Pizza!", "Cat's are cool"));
    }

}
