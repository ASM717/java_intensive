package day00.ex00;

/*
    Exercise 00 : Sum of Digits
 */

public class Program {

    public static void main(String[] args) {
        int number = 479598;
        int sumOfDigits = 0;

        sumOfDigits += number % 10;
        number /= 10;
        sumOfDigits += number % 10;
        number /= 10;
        sumOfDigits += number % 10;
        number /= 10;
        sumOfDigits += number % 10;
        number /= 10;
        sumOfDigits += number % 10;
        number /= 10;
        sumOfDigits += number % 10;

        System.out.println(sumOfDigits);
    }
}
