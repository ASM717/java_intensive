package edu.school21.numbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class NumberWorkerTest {
    private static final NumberWorker numberWorker = new NumberWorker();

    @ParameterizedTest
    @ValueSource(ints = { 2, 3, 7, 11, Integer.MAX_VALUE })
    void isPrimeForPrimes(int argument) {
        assertTrue(numberWorker.isPrime(argument));
    }

    @ParameterizedTest
    @ValueSource(ints = { 4, 9, 20, 292, Integer.MAX_VALUE - 1})
    void isPrimeForNotPrimes(int argument) {
        assertFalse(numberWorker.isPrime(argument));
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 1, -20, Integer.MIN_VALUE })
    void isPrimeForIncorrectNumbers(int argument) {
        assertThrows(IllegalNumberException.class, () -> numberWorker.isPrime(argument));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void trueDigitSum(int number, int sum) {
        assertEquals(sum, numberWorker.digitSum(number));
    }
}
