package day01.ex01;

public class Program {
    public static void main(String[] args) {
        User user1 = new User("Lena", 10000);
        User user2 = new User("Grisha", 10000);
        User user3 = new User("Marina", 10000);
        User user4 = new User("Volodya", 10000);


        System.out.println(user1.getName() + " ID: " + user1.getIdentifier());
        System.out.println(user2.getName() + " ID: " + user2.getIdentifier());
        System.out.println(user3.getName() + " ID: " + user3.getIdentifier());
        System.out.println(user4.getName() + " ID: " + user4.getIdentifier());
    }
}
