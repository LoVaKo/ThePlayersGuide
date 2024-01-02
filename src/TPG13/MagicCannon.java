package TPG13;

public class MagicCannon {
    public static void main(String[] args) {

        for (int numCranks = 1; numCranks < 101; numCranks++) {
            boolean isDivisibleBy3 = numCranks % 3 == 0;
            boolean isDivisibleBy5 = numCranks % 5 == 0;

            if (!isDivisibleBy3 && !isDivisibleBy5) {
                System.out.println(numCranks + ": Normal");
            } else if (isDivisibleBy3 && !isDivisibleBy5) {
                System.out.println(numCranks + ": \u001b[31mFire\u001b[0m");
            } else if (!isDivisibleBy3) {
                System.out.println(numCranks + ": \u001b[33mElectric\u001b[0m");
            } else {
                System.out.println(numCranks + ": \u001b[34mCombined Blast\u001b[0m");
            }
        }
    }
}
