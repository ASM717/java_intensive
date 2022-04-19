package ex02;

import ex00.User;

import java.util.UUID;

public class Transaction {
    enum TransferCategory {
        CREDIT("OUTCOME", ""), DEBIT("INCOME", "+");

        private final String text;
        private final String sign;

        TransferCategory(String text, String sign) {
            this.text = text;
            this.sign = sign;
        }

        @Override
        public String toString() {
            return text;
        }

        public String getSign() {
            return sign;
        }
    }

    private UUID identifier;
    private ex00.User recipient;
    private ex00.User sender;
    private TransferCategory transferCategory;
    private Integer amount;

    public Transaction(ex00.User recipient, ex00.User sender, TransferCategory transferCategory, Integer amount) {
        identifier = UUID.randomUUID();
        this.recipient = recipient;
        this.sender = sender;
        this.transferCategory = transferCategory;
        this.amount = amount;
    }

    public static Transaction createTransaction(ex00.User recipient,
                                                ex00.User sender,
                                                TransferCategory transferCategory,
                                                Integer amount) {
        if ((transferCategory == TransferCategory.CREDIT && amount < 0 && recipient.getBalance() >= (-amount))
                || (transferCategory == TransferCategory.DEBIT && amount > 0 && sender.getBalance() >= amount)) {
            return new Transaction(recipient, sender, transferCategory, amount);
        }
        return null;
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public void setIdentifier(UUID identifier) {
        if (identifier.toString().length() > 0)
            this.identifier = identifier;
    }

    public ex00.User getRecipient() {
        return recipient;
    }

    public User getSender() {
        return sender;
    }


    public TransferCategory getTransferCategory() {
        return transferCategory;
    }


    public Integer getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return ("Transaction { " +
                sender.getName() + " -> " +
                recipient.getName() + ", " +
                transferCategory.getSign() +
                amount + ", " +
                transferCategory + ", " + identifier + " }");
    }
}
