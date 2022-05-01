package day01.ex03;

public class User {
    private Integer identifier;
    private String name;
    private Integer balance;
    private TransactionsList list;

    public User(String name, Integer balance) {
        if (balance > 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
        }
        this.name = name;
        identifier = UserIdsGenerator.getInstance().generateId();
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public TransactionsList getList() {
        return list;
    }

    public void setList(TransactionsList list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "identifier = " + identifier +
                ", name = '" + name + '\'' +
                ", balance = " + balance;
    }
}
