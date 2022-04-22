package ex01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Program {

    private static HashSet<String> stringTreeSet = new HashSet<>();
    private static ArrayList<String> inputFileA = new ArrayList<>();
    private static ArrayList<String> inputFileB = new ArrayList<>();

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Wrong number of arguments");
            System.exit(-1);
        }
        try {
            FileInputStream inputStreamA = new FileInputStream(args[0]);
            FileInputStream inputStreamB = new FileInputStream(args[1]);

            Scanner scanFileA = getScannerForA(inputStreamA);
            stringTreeSet.addAll(inputFileA);
            Scanner scanFileB = getScannerForB(inputStreamB);
            stringTreeSet.addAll(inputFileB);
            FileOutputStream fileOutputStream = new FileOutputStream("/Users/amuriel/Desktop/day02/src/ex01/dictionary.txt");
            for (Iterator<String> it = stringTreeSet.iterator(); it.hasNext(); ) {
                byte[] bytes = (it.next() + " ").getBytes();
                fileOutputStream.write(bytes);
            }
            String str = String.format("%.3f", similarity());
            if (str.substring(0, str.length() - 1).equals("Na"))
                System.out.println("Similarity = 0");
            else
                System.out.println("Similarity = " + str.substring(0, str.length() - 1));
            scanFileB.close();
            scanFileA.close();
            inputStreamB.close();
            inputStreamA.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Scanner getScannerForB(FileInputStream inputStreamB) {
        Scanner scanFileB = new Scanner(inputStreamB);
        while (scanFileB.hasNext()) {
            String next = scanFileB.next();
            String[] arrB = next.split(" ");
            inputFileB.addAll(Arrays.asList(arrB));
        }
        return scanFileB;
    }

    private static Scanner getScannerForA(FileInputStream inputStreamA) {
        Scanner scanFileA = new Scanner(inputStreamA);
        while (scanFileA.hasNext()) {
            String next = scanFileA.next();
            String[] arrA = next.split(" ");
            inputFileA.addAll(Arrays.asList(arrA));
        }
        return scanFileA;
    }

    public static int numenatorFind(ArrayList<Integer> listA, ArrayList<Integer> listB) {
        int sumofmulress = 0;
        for (int i = 0; i < stringTreeSet.size(); i++)
            sumofmulress += listA.get(i) * listB.get(i);
        return sumofmulress;
    }

    public static double denominatorFunc(ArrayList<Integer> arrA, ArrayList<Integer> arrB) {
        double squaredASum = 0;
        for (Integer x : arrA)
            squaredASum += x * x;
        double squaredBSum = 0;
        for (Integer x : arrB)
            squaredBSum += x * x;
        return Math.sqrt(squaredASum) * Math.sqrt(squaredBSum);

    }

    public static double similarity() {
        ArrayList<Integer> periodicA = new ArrayList<>(stringTreeSet.size());
        ArrayList<Integer> periodicB = new ArrayList<>(stringTreeSet.size());

        pereodicFillArr(periodicA, periodicB);
        int numerator = numenatorFind(periodicA, periodicB);
        double denominator = denominatorFunc(periodicA, periodicB);
        return numerator / denominator;
    }

    public static void pereodicFillArr(ArrayList<Integer> arrA, ArrayList<Integer> arrB) {
        int countA = 0;
        int i = 0;
        for (String elem : stringTreeSet) {
            for (String elemFromA : inputFileA)
                if (elem.equals(elemFromA))
                    countA++;
            arrA.add(i, countA);
            countA = 0;
            i++;
        }
        i = 0;
        for (String elem : stringTreeSet) {
            for (String elemFromB : inputFileB)
                if (elem.equals(elemFromB))
                    countA++;
            arrB.add(i, countA);
            countA = 0;
            i++;
        }
    }
}
