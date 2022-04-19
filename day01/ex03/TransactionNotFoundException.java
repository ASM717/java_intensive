package ex03;

public class TransactionNotFoundException extends RuntimeException {
    @Override
    public String toString() {
        return "TransactionNotFoundException { Transaction not found! }";
    }
}
