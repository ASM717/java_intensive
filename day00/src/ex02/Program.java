package ex02;

import java.util.Scanner;

/*
    Exercise 02 : Endless Sequence (or not?)
 */

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            printError();
        }
        int sum = 0;
        int input = scanner.nextInt();
        int cofCounter = 0;
        for (; input != 42; input = scanner.nextInt()) {

            if (!scanner.hasNextInt()) {
                scanner.close();
                printError();
            }
            for (; input > 0; input = input / 10)
                sum += input % 10;
            if (checkPrimeSum(sum))
                cofCounter++;
        }
        System.out.println("Count of coffee-request - " + cofCounter);
        scanner.close();
    }

    private static boolean checkPrimeSum(int sum) {
        boolean prime = true;
        for (int i = 2; i * i <= sum; i++) {
            if (sum % i == 0) {
                prime = false;
                break;
            }
        }
        return (prime);
    }

    private static void printError() {
        System.err.println("Illegal Argument");
        System.exit(-1);
    }
}