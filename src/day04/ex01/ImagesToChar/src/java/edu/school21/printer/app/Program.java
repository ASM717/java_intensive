package day04.ex01.ImagesToChar.src.java.edu.school21.printer.app;

import day04.ex01.ImagesToChar.src.java.edu.school21.printer.logic.Operation;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Program {
    public static void main(String[] args) {
        if (args.length != 2 || args[0].length() != 1 || args[1].length() != 1) {
            System.err.println("Illegal Argument ! Check README !");
            System.exit(-1);
        }

        char white = args[0].charAt(0);
        char black = args[1].charAt(0);

        try {
            URL path = Program.class.getResource("/resources/it.bmp");
            assert path != null;
            BufferedImage img = ImageIO.read(path);
            Operation.convert(img, white, black);
        } catch (IOException e) {
            System.err.println("Error!");
            System.exit(-1);
        }
    }
}
