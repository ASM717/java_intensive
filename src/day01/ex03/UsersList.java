package day01.ex03;

public interface UsersList {
    void addUser(User user);
    User retrieveUserById(Integer id);
    User retrieveUserByIndex(Integer id);
    Integer retrieveNumberOfUsers();
}