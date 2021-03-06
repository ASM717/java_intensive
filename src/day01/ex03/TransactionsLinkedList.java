package day01.ex03;

public class TransactionsLinkedList implements TransactionsList {
    public class Node {
        private Transaction transaction;
        private Node next;
        private Node prev;

        public Node(Transaction transaction) {
            this.transaction = transaction;
        }

        public void insertLastElem(Node end) {
            prev = end.prev;
            prev.next = this;
            end.prev = this;
            next = end;
        }

        public void cutElem() {
            next.prev = prev;
            prev.next = next;
            next = null;
            prev = null;
        }

        public Transaction getTransaction() {
            return transaction;
        }

    }

    private Node start;
    private Node end;
    private Integer count;

    public TransactionsLinkedList() {
        start = new Node(null);
        end = new Node(null);

        start.next = end;
        end.prev = start;
        count = 0;
    }

    @Override
    public void add(Transaction transaction) {
        (new Node(transaction)).insertLastElem(end);
        count++;
    }

    @Override
    public Transaction remove(String uuid) {
        Node node = start.next;
        while (node != end) {
            if (uuid.equals(node.getTransaction().getIdentifier().toString())) {
                node.cutElem();
                count--;
                return node.getTransaction();
            }
            node = node.next;
        }
        throw new TransactionNotFoundException();
    }

    @Override
    public Transaction[] toArray() {
        Transaction[] transactions = new Transaction[count];
        Node node = start.next;
        for (int i = 0; i < count; i++, node = node.next) {
            transactions[i] = node.getTransaction();
        }
        return transactions;
    }
}
