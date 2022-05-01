package day01.ex02;

public class UserNotFoundException extends RuntimeException {
    @Override
    public String toString() {
        return "UserNotFoundException { User not Found! }";
    }
}
