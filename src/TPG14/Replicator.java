package TPG14;

import java.util.Arrays;
import java.util.Scanner;
public class Replicator {

    public static void main(String[] args) {
        int[] array1 = new int[5];
        int[] array2 = new int[5];

        Scanner scanner = new Scanner(System.in);

        System.out.println("Provide 5 integer numbers for the original array");
        for (int i = 0; i < 5; i++) {
            if(scanner.hasNextInt()) {
                array1[i] = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please provide integer numbers.");
                scanner.next();
                i--;
            }
        }

        // Copying array1 to array2.
        System.arraycopy(array1, 0, array2, 0, array1.length);

        System.out.println("The first array is:" + Arrays.toString(array1));
        System.out.println("The second array is:" + Arrays.toString(array2));
        System.out.println("The Replicator of D'To is working once more!");
    }
}