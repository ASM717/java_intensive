package ex00;

public class Program {
    public static void main(String[] args) {
        User john = new User("John", 10000);
        john.setIdentifier(1);
        User mike = new User("Mike", 100000);
        mike.setIdentifier(2);

        Transaction transaction1 = Transaction.createTransaction(mike, john, Transaction.TransferCategory.CREDIT, -500);
        Transaction transaction2 = Transaction.createTransaction(john, mike, Transaction.TransferCategory.DEBIT, 500);

        System.out.println(transaction1);
        System.out.println(transaction2);

        john.setBalance(john.getBalance() - 500);
        System.out.println("Check balance: " + john.getName() + " " + john.getBalance());

        mike.setBalance(mike.getBalance() + 500);
        System.out.println("Check balance: " + mike.getName() + " " + mike.getBalance());

        transaction1 = Transaction.createTransaction(john, mike, Transaction.TransferCategory.DEBIT, -3000);
        System.out.println(transaction1);

        transaction1 = Transaction.createTransaction(john, mike, Transaction.TransferCategory.DEBIT, 200000);
        System.out.println(transaction1);

        transaction1 = Transaction.createTransaction(john, mike, Transaction.TransferCategory.CREDIT, 200000);
        System.out.println(transaction1);

        mike.setBalance(200);
        System.out.println(mike.getBalance());

    }
}
