package ex01;

public class Program implements Runnable {
    private static int iterCount;
    private final String message;

    private static String key = "Hen";

    public static void main(String[] args) {
        if (args.length != 1 || !args[0].startsWith("--count=")) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        String[] cntArr = args[0].split("=");
        if (cntArr.length != 2) {
            System.err.println("Error argument's!");
            System.exit(-1);
        }
        try {
            iterCount = Integer.parseInt(cntArr[1]);
            if (iterCount <= 0) {
                System.err.println("Error argument's");
                System.exit(-1);
            }
        } catch (NumberFormatException e) {
            System.err.println("Error argument's");
            System.exit(-1);
        }
        multirow();
    }

    private static void multirow() {
        Thread eggThread = new Thread(new Program(iterCount, "Egg"));
        Thread henThread = new Thread(new Program(iterCount, "Hen"));

        eggThread.start();
        henThread.start();

        try {
            eggThread.join();
            henThread.join();
        } catch (InterruptedException e) {
            System.err.println("Error! join failed!");
            System.exit(-1);
        }
    }

    public Program(int iterCount, String message) {
        this.message = message;
        Program.iterCount = iterCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < iterCount; ) {
            synchronized (Program.class) {
                if (!(key.equals(message))) {
                    System.out.println(message);
                    key = message;
                    i++;
                }
            }
        }
    }
}
