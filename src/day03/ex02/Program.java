package day03.ex02;

import java.util.*;

public class Program {
    private static int arrSize;
    private static int threadsCount;
    private static int[] array;
    private static int number;

    public static void main(String[] args) {
        if (args.length != 2 || !args[0].startsWith("--arraySize=") || !args[1].startsWith("--threadsCount=")) {
            System.err.println("Wrong argument's! Enter [--arraySize= ] [--threadsCount= ]");
            System.exit(-1);
        }

        String[] arraySizeArr = args[0].split("=");
        String[] threadsCountArr = args[1].split("=");

        checkArguments(arraySizeArr, threadsCountArr);
        operationWithArrays();
    }

    private static void checkArguments(String[] arraySizeArr, String[] threadsCountArr) {
        if (arraySizeArr.length != 2 || threadsCountArr.length != 2) {
            System.err.println("Error argument's!");
            System.exit(-1);
        }

        try {
            arrSize = Integer.parseInt(arraySizeArr[1]);
            threadsCount = Integer.parseInt(threadsCountArr[1]);
        } catch (NumberFormatException e) {
            System.err.println("Illegal Argument");
            System.exit(-1);
        }

        if (arrSize > 2000000 || threadsCount > arrSize || threadsCount <= 0) {
            System.err.println("Illegal Argument");
            System.exit(-1);
        }
    }

    private static void operationWithArrays() {
        array = new int[arrSize];
        Random random = new Random();
        for (int i = 0; i < arrSize; i++)
            array[i] = random.nextInt(1000);
        List<int[]> listOfIntegers;
        listOfIntegers = Collections.singletonList(array);
        long summary = 0;
        for (int[] elem : listOfIntegers)
            summary = Arrays.stream(elem).sum();
        System.out.println("Sum: " + summary);
        findNod();
        List<Operation> threads = createThreads();
        try {
            System.out.println("Sum by threads: " + executeByThreads(threads));
        } catch (Exception e) {
            System.err.println("Problem with execute!");
        }
    }

    private static void findNod() {
        if (threadsCount == 1)
            number = arrSize / threadsCount;
        else number = (arrSize - 1) / (threadsCount - 1);
    }

    private static List<Operation> createThreads() {
        List<Operation> operationList = new ArrayList<>(arrSize);
        int j = 0;
        for (int i = 0; i < threadsCount - 1 && j < arrSize - 1; ++i, ++j) {
            int start = j;
            j += (number - 1);
            int end = j;
            Operation operation = new Operation(array, start, end);
            operationList.add(operation);
        }
        Operation calc = new Operation(array, j, arrSize - 1);
        operationList.add(calc);
        return operationList;
    }

    private static long executeByThreads(List<Operation> operationList)  {
        for (Operation deque : operationList) {
            deque.start();
        }
        long i = 0;
        for (Operation elem : operationList) {
            try {
                elem.join();
            } catch (InterruptedException e) {
                System.err.println("InterruptedException");
            }
            i += elem.getSummary();
        }
        return i;
    }
}
