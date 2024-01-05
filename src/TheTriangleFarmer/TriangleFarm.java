package TheTriangleFarmer;

import java.util.Scanner;

public class TriangleFarm {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the width of the base of the triangle in cm.");
        double base = input.nextDouble();
        System.out.println("Enter the height of the triangle in cm.");
        double height = input.nextDouble();
        double area = base * height / 2;
        System.out.println("The area of your triangle in squared cm is: " + area);
    }
}
