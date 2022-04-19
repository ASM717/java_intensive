package ex01;

import java.util.Scanner;

/*
    Exercise 01 : Really Prime Number
 */

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            printError();
        }

        int number = scanner.nextInt();
        boolean prime = true;
        int count = 1;

        if (number <= 1) {
            scanner.close();
            printError();
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                prime = false;
                break;
            }
            count++;
        }
        System.out.println(prime + " " + count);
        scanner.close();
    }

    private static void printError() {
        System.err.println("Illegal Argument");
        System.exit(-1);
    }
}
