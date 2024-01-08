package Asynchronous;

import java.util.Random;
import java.util.concurrent.Callable;

public class RandomWords implements Callable<Integer> {
    private final String targetWord;

    public RandomWords(String targetWord) {
        this.targetWord = targetWord.toLowerCase();
    }

    @Override
    public Integer call() {
        Random random = new Random();
        int numAttempts = 0;
        String randomString;

        do {
            StringBuilder newString = new StringBuilder();
            for (int i = 0; i < targetWord.length(); i++) {
                newString.append((char) ('a' + (random.nextInt(26))));
            }
            randomString = newString.toString();
            numAttempts++;
        } while (!randomString.equals(targetWord));

        return numAttempts;
    }
}
