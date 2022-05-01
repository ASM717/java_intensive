package day02.ex00;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream inputStream = new FileInputStream("/Users/amuriel/Desktop/day02/src/ex00/signatures.txt");
        FileOutputStream resultFile = new FileOutputStream("/Users/amuriel/Desktop/day02/src/ex00/result.txt", true);
        Scanner scanner = new Scanner(inputStream);
        Scanner inputScan = new Scanner(System.in);
        Map<String, String> hashMap = getStringMap(scanner);
        bifLoopFunc(resultFile, hashMap, inputScan);
        scanner.close();
        inputScan.close();
    }

    private static Map<String, String> getStringMap(Scanner scanner) {
        Map<String, String> hashMap = new HashMap<>();
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            String[] value = str.split(", ");
            hashMap.put(value[1].replaceAll("\\s+", ""), value[0]);
        }
        return hashMap;
    }

    private static void bifLoopFunc(FileOutputStream resultFile, Map<String, String> hashMap, Scanner inputScan) {
        String inputString;

        while (!(inputString = inputScan.nextLine()).equals("42")) {
            try {
                FileInputStream fileInputStream = new FileInputStream(inputString);
                StringBuilder stringWithHex = new StringBuilder();
                int controlFlag = 0;
                for (int i = 0; i < 16; i++) {
                    stringWithHex.append(String.format("%02X", fileInputStream.read()));
                }

                for (String s : hashMap.keySet()) {

                    String tmp = stringWithHex.toString();
                    String value;
                    if (tmp.startsWith(s)) {
                        value = hashMap.get(s);
                        resultFile.write(value.getBytes());
                        resultFile.write('\n');
                        controlFlag = 1;
                        System.out.println("PROCESSED");
                    }
                }
                if (controlFlag == 0) {
                    System.out.println("UNDEFINED");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
