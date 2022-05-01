package day04.ex00.ImagesToChar.src.java.edu.school21.printer.app;

import day04.ex00.ImagesToChar.src.java.edu.school21.printer.logic.Operation;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Program {

    public static void main(String[] args) {
        if (args.length != 3 || args[0].length() != 1 || args[1].length() != 1) {
            System.err.println("Illegal Argument ! Check README !");
            System.exit(-1);
        }
        char white = args[0].charAt(0);
        char black = args[1].charAt(0);
        String dirPicture = args[2];

        try {
            File file = new File(dirPicture);
            BufferedImage img = ImageIO.read(file);
            Operation.convert(img, white, black);
        } catch (IOException e) {
            System.err.println("Error!");
            System.exit(-1);
        }
    }
}
