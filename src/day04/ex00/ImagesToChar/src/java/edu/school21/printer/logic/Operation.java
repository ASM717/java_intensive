package day04.ex00.ImagesToChar.src.java.edu.school21.printer.logic;

import java.awt.image.BufferedImage;

public class Operation {
    public static void convert(BufferedImage bufferedImage, char whiteChar, char blackChar) {
        for (int i = 0; i < bufferedImage.getHeight(); i++) {
            for (int j = 0; j < bufferedImage.getWidth(); j++) {
                if (bufferedImage.getRGB(j, i) == -1)
                    System.out.print(whiteChar);
                else System.out.print(blackChar);
            }
            System.out.println();
        }
    }
}
