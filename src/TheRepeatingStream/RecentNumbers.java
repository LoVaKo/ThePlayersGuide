package TheRepeatingStream;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RecentNumbers {
    private final Lock lock;
    private int firstNum;
    private int secondNum;

    // Constructor, Getters, Setters
    public RecentNumbers(int x, int y) {
        this.firstNum = x;
        this.secondNum = y;
        this.lock = new ReentrantLock();
    }

    public static void main(String[] args) {
        RecentNumbers numbers = new RecentNumbers(0, 0);

        Thread numberGenerationThread = new Thread(() -> {
            try {
                numbers.numberStream();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        numberGenerationThread.start();

        Thread enterKeyThread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                scanner.nextLine();
                if (numbers.isIdentical()) {
                    System.out.println("You correctly identified the repeat!");
                } else {
                    System.out.println("Oops, the numbers are not identical.");
                }
            }
        });
        enterKeyThread.start();

    }

    // Looping method producing numbers
    public void numberStream() throws InterruptedException {
        Random random = new Random();

        while (true) {
            Thread.sleep(1000);

            lock.lock();
            setFirstNum(random.nextInt(10));
            setSecondNum(random.nextInt(10));
            lock.unlock();

            System.out.println(getFirstNum() + " " + getSecondNum());
        }
    }

    // Method to check for double numbers
    public boolean isIdentical() {
        lock.lock();
        boolean result = firstNum == secondNum;
        lock.unlock();
        return result;
    }

    public int getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(int firstNum) {
        this.firstNum = firstNum;
    }

    public int getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(int secondNum) {
        this.secondNum = secondNum;
    }
}
