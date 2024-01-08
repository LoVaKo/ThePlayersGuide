package Asynchronous;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                "If you put an endless amount of monkeys behind a typewriter, one monkey will produce the entire works of Shakespeare."
                Bit much, but this program WILL randomly pick letters and form words. Feed it a word, and it will show the number of attempts it needed to come up with the same word, and the time in milliseconds it took your computer.
                The program is capped at 6 letter words, because with 10 letters it might already take a few years. And who has that amount of time, right?
                You can have multiple requests running at one. If you want to end the program, enter "exit".
                """);


        while (true) {
            String targetWord;

            do {
                System.out.println("Please enter a word with no more than 6 letters: ");
                targetWord = scanner.nextLine();
            } while (targetWord.length() > 6);

            if (targetWord.equalsIgnoreCase("exit")) break;

            long startTime = System.currentTimeMillis();
            RandomWords randomWordsTask = new RandomWords(targetWord.toLowerCase());
            Future<Integer> futureResult = executorService.submit(randomWordsTask);

            try {
                Integer attempts = futureResult.get();
                System.out.println("Attempts made for " + targetWord + ": " + attempts);
            } catch (Exception e) {
                e.printStackTrace();
            }

            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            System.out.println("Time elapsed for " + targetWord + ": " + totalTime + " milliseconds.");

        }

        executorService.shutdown();
    }
}
