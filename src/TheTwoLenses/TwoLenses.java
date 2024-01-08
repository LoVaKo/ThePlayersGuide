package TheTwoLenses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TwoLenses {
    public static List<Integer> proceduralCode(int[] arr) {
        List<Integer> result = new ArrayList<>();

        // Sorting array
        Arrays.sort(arr);

        // Adding even numbers
        for (int n : arr) {
            if (n % 2 == 0) result.add(n);
        }

        // Double the numbers
        result.replaceAll(integer -> integer * 2);

        return result;
    }

    public static List<Integer> lambdas(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .sorted()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(proceduralCode(new int[]{1, 9, 2, 8, 3, 7, 4, 6, 5}));
        System.out.println(lambdas(new int[]{1, 9, 2, 8, 3, 7, 4, 6, 5}));
    }
}
