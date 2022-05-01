package day01.ex02;

public class Program {
    public static void main(String[] args) {
        User user1 = new User("name1", 10000);
        User user2 = new User("name2", 100000);
        User user3 = new User("name3", 100000);
        User user4 = new User("name4", 100000);
        User user5 = new User("name5", 100000);
        User user6 = new User("name6", 100000);
        User user7 = new User("name7", 100000);
        User user8 = new User("name8", 100000);
        User user9 = new User("name9", 100000);
        User user10 = new User("name10", 100000);
        User user11 = new User("name11", 100000);

        UsersList list = new UsersArrayList();
        list.addUser(user1);
        list.addUser(user2);
        list.addUser(user3);
        list.addUser(user4);
        list.addUser(user5);
        list.addUser(user6);
        list.addUser(user7);
        list.addUser(user8);
        list.addUser(user9);
        list.addUser(user10);
        list.addUser(user11);

        System.out.println("count = " + list.retrieveNumberOfUsers());
        System.out.println(list.retrieveUserByIndex(0) + "| == |" + user1);
        System.out.println(list.retrieveUserByIndex(user2.getIdentifier()) + "| == |" + user2);
        System.out.println(list.retrieveUserById(8));
//        User user12 = new User("name12", 100000);
//        System.out.println(list.retrieveUserById(user12.getIdentifier()));
    }
}
