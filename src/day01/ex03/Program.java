package day01.ex03;

public class Program {
    public static void main(String[] args) {
        User user1 = new User("name1", 121777);
        User user2 = new User("name2", 212777);
        User user3 = new User("name3", 333777);

        TransactionsList list = new TransactionsLinkedList();

        user1.setList(list);
        user2.setList(list);
        user3.setList(list);

        Transaction transaction1 = Transaction.createTransaction(user2, user1, Transaction.TransferCategory.CREDIT, -500);
        Transaction transaction2 = Transaction.createTransaction(user1, user2, Transaction.TransferCategory.DEBIT, 500);
        Transaction transaction3 = Transaction.createTransaction(user2, user3, Transaction.TransferCategory.CREDIT, -500);
        Transaction transaction4 = Transaction.createTransaction(user3, user2, Transaction.TransferCategory.DEBIT, 500);
        Transaction transaction5 = Transaction.createTransaction(user2, user1, Transaction.TransferCategory.CREDIT, -500);
        Transaction transaction6 = Transaction.createTransaction(user1, user3, Transaction.TransferCategory.DEBIT, 500);

        list.add(transaction1);
        list.add(transaction2);
        list.add(transaction3);
        list.add(transaction4);

        System.out.println(" ============================================================================");
        for (Transaction t : list.toArray()) {
            System.out.println(t);
        }
        System.out.println(" ============================================================================");

        System.out.println("delete");
        System.out.println(list.remove(transaction2.getIdentifier().toString()));
        System.out.println(" ============================================================================");
        System.out.println("after | del");
        for (Transaction t : list.toArray()) {
            System.out.println(t);
        }
        list.remove(transaction4.getIdentifier().toString());
        System.out.println("after | del");
        for (Transaction t : list.toArray()) {
            System.out.println(t);
        }
        list.add(transaction5);
        list.add(transaction6);
        System.out.println(" ============================================================================");
        System.out.println("after | add 2 transaction");
        for (Transaction t : list.toArray()) {
            System.out.println(t);
        }
    }
}
