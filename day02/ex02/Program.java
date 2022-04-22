package ex02;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;

public class Program {

    private static String path;

    public static void main(String[] args) {
        if (args.length != 1 || !args[0].startsWith("--current-folder")) {
            System.err.println("Java Program --current-folder=PATH");
            System.exit(-1);
        }
        Dir();
        String split[] = args[0].split("=");
        if (split.length != 2 || !isCurrentPath(split[1])) {
            System.err.println("Java Program --current-folder=PATH");
            System.exit(-1);
        }
        cd(split[1]);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                applyCommand(br.readLine().trim());
            }
        } catch (IOException e) {
            System.err.println("Can't read from System.in");
            System.exit(-1);
        }
    }

    private static void applyCommand(String line) {
        String commands[] = line.split(" +");

        if (commands[0].equals("ls")) {
            if (commands.length == 1)
                ls();
            else if (commands.length == 2)
                ls(commands[1]);
            else
                System.err.println("To many arguments");
        }
        else if (commands[0].equals("cd")) {
            if (commands.length == 1)
                return;
            else if (commands.length == 2)
                cd(commands[1]);
            else
                System.err.println("To many arguments");
        } else if (commands[0].equals("mv")) {
            if (commands.length != 3)
                System.err.println("need src and dest");
            else
                mv(commands[1], commands[2]);
        } else if (commands[0].equals("exit"))
            System.exit(0);
        else
            System.err.println("Unknown command");
    }


    public static void Dir() {
        path = "";
    }

    public static void ls() {
        ls(path);
    }

    public static void ls(String path) {
        File file = new File(getPath(path));
        if (!file.exists())
            return;
        for (File f : listFiles(file))
            System.out.printf("%s %dKB\n", f.getName(), getSize(f) / 1024);
    }

    public static boolean isCurrentPath(String path) {
        File file = new File(getPath(path));
        if (file.exists() && file.isDirectory())
            return true;
        else
            return false;
    }

    public static void cd(String next) {
        if (next.isEmpty())
            return;

        File file = new File(getPath(next));
        if (file.exists() && file.isDirectory()) {
            path = file.toPath().normalize().toString();
            System.out.println(path);
        } else
            System.err.println("No such directory");
    }

    private static String getPath(String name) {
        if (name.startsWith("/"))
            return name;
        else if (name.startsWith("./"))
            return path + name.substring(1);
        return path + "/" + name;
    }

    public static void mv(String from, String to) {
        if (from.equals(to))
            return;
        from = getPath(from);
        to = getPath(to);
        File file = new File(from);
        File fileTo = new File(to);
        if (!file.exists()) {
            System.err.println("where is no such file" + from);
            return;
        }
        if (fileTo.exists() && fileTo.isDirectory())
            fileTo = new File(fileTo.getAbsolutePath() + "/" + file.getName());
        try {
            Files.move(file.toPath(), fileTo.toPath());
        } catch (IOException e) {
            System.err.println("where is no such directory");
        }
    }

    private static File[] listFiles(File file) {
        File files[] = file.listFiles();
        if (files == null)
            return new File[0];
        return files;
    }

    private static long getSize(File file) {
        if (!file.isDirectory())
            return file.length();
        long size = 0;
        for (File f : listFiles(file))
            size += getSize(f);
        return size;
    }
}
