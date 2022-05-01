package day03.ex02;

public class Operation extends Thread {
    private final int[] arr;
    private final int threadId;
    private final int start;
    private final int end;
    private long summary;
    private static int lastId = 1;

    public Operation(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
        threadId = lastId++;
    }

    public long getSummary() {
        return summary;
    }

    @Override
    public void run() {
        summary = 0;
        for (int i = start; i <= end; i++) {
            summary += arr[i];
        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Thread "
                + threadId
                + ": from "
                + start
                + " to "
                + end
                + " sum is "
                + summary;
    }
}
