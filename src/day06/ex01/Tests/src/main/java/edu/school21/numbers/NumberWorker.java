package edu.school21.numbers;

public class NumberWorker {

    public boolean isPrime(int num) throws IllegalNumberException {
        if (num < 2) {
            throw new IllegalNumberException("Not a natural number!");
        }
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public int digitSum(int num) {
        int summ = 0;

        while (num != 0) {
            summ += (num % 10);
            num /= 10;
        }
        return summ;
    }
}
