package day00.ex04;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] amountArr = new int[65536];
        int[] idx = new int[10];

        if (!scanner.hasNextLine())
            printErrorWithStopScan(scanner);
        char[] arrLine = scanner.nextLine().toCharArray();
        scanner.close();
        if (arrLine.length == 0)
            System.exit(0);
        findMinElem(arrLine, amountArr, idx);
        checkAllArray(amountArr, idx);
        int sizeRow = sizeRow(amountArr, idx);
        int maximum = amountArr[idx[0]];
        if (maximum > 999)
            printError();
        print(maximum, amountArr, sizeRow, idx, sizeRow);
    }

    private static int sizeRow(int[] amountArr, int[] idx) {
        int size = 1;
        for (int i = 0; i < 10; i++) {
            if (amountArr[idx[i]] == 0) {
                break;
            }
            size = i + 1;
        }
        return (size);
    }

    private static void print(int max, int[] amountArr, int size, int[]idx, int sizeRow) {
        for (int i = 11; i > 0; i--) {
            int heightColomn = (max * i);
            int nextColomn = (max * (i - 1));

            for (int j = 0; j < size; j++) {
                if (amountArr[idx[j]] * 10 >= heightColomn) {
                    System.out.print("  #");
                } else if (amountArr[idx[j]] * 10 >= nextColomn) {
                    System.out.printf("% 3d", amountArr[idx[j]]);
                } else {
                    break;
                }
            }
            System.out.println("");
        }

        for (int i = 0; i < sizeRow; i++) {
            System.out.printf("  %c", (char) idx[i]);
        }
        System.out.println();
    }

    private static void findMinElem(char[] arrLine, int[] amountArr, int[] idx) {
        for (char c : arrLine) {
            amountArr[c]++;
        }

        int min = 0;
        for (int i = 0; i < amountArr.length; i++) {
            if (amountArr[i] == 0 || amountArr[i] < amountArr[idx[min]]) {
                continue;
            }
            idx[min] = i;
            min = 0;
            for (int j = 1; j < 10 && amountArr[idx[min]] > 0; j++) {
                if (amountArr[idx[min]] >= amountArr[idx[j]]) {
                    min = j;
                }
            }
        }
    }

    private static void checkAllArray(int[] amountArr, int[] idx) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                if (amountArr[idx[j]] < amountArr[idx[j + 1]]) {
                    int tmp = idx[j + 1];
                    idx[j + 1] = idx[j];
                    idx[j] = tmp;
                }
            }
        }
    }

    private static void printErrorWithStopScan(Scanner scanner) {
        scanner.close();
        System.err.println("Illegal Argument");
        System.exit(-1);
    }

    private static void printError() {
        System.err.println("Illegal Argument");
        System.exit(-1);
    }
}
