package ex02;

public class UsersArrayList implements UsersList {
    private User[] arrayList = new User[10];
    private Integer cntUsers = 0;

    @Override
    public void addUser(User user) {
        if (arrayList.length == cntUsers) {
            User[] newArr = new User[cntUsers + cntUsers];
            for (int i = 0; i < arrayList.length; ++i)
                newArr[i] = arrayList[i];
            arrayList = newArr;
        }
        arrayList[cntUsers] = user;
        cntUsers++;
    }

    @Override
    public User retrieveUserById(Integer id) {
        for (int i = 0; i < cntUsers; i++) {
            if (id.equals(arrayList[i].getIdentifier())) {
                return arrayList[i];
            }
        }
        throw new UserNotFoundException();
    }

    @Override
    public User retrieveUserByIndex(Integer id) {
        if (id >= cntUsers || id < 0)
            throw new ArrayIndexOutOfBoundsException();
        return arrayList[id];
    }

    @Override
    public Integer retrieveNumberOfUsers() {
        return cntUsers;
    }
}
