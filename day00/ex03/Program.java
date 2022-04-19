package ex03;

/*
    Exercise 03 : A Little Bit of Statistics
 */

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long weekKeeping = 0;
        int cntWeek = 1;
        String line;

        while (!(line = scanner.nextLine()).equals("42")) {
            if (!line.equals(("Week " + cntWeek)) || cntWeek > 18) {
                scanner.close();
                printError();
            }
            long grade = 10;
            for (int i = 0; i < 5; i++) {
                if (!scanner.hasNextInt()) {
                    scanner.close();
                    printError();
                }
                int rowGrade = scanner.nextInt();
                if (rowGrade > 9 || rowGrade < 1) {
                    scanner.close();
                    printError();
                }
                if (rowGrade < grade)
                    grade = rowGrade;
            }
            scanner.nextLine();
            for (int i = 0; i < cntWeek; i++)
                grade = grade * 10;
            weekKeeping += grade;
            cntWeek++;
        }
        scanner.close();
        printStatistic(weekKeeping, cntWeek);
    }

    private static void printError() {
        System.err.println("\nIllegal Argument");
        System.exit(-1);
    }

    private static void printStatistic(long weekKeeping, int cntWeek) {
        if (cntWeek > 19)
            System.out.println();
        weekKeeping /= 10;
        int i = 1;
        while (i < cntWeek) {
            System.out.print("Week " + i + (i < 10 ? "  " : " "));
            long res = weekKeeping % 10;
            while (res > 0) {
                System.out.print("=");
                res--;
            }
            System.out.println(">");
            weekKeeping /= 10;
            i++;
        }
    }
}
