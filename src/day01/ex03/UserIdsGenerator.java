package day01.ex03;

public class UserIdsGenerator {

    private static Integer lastGenId = 1;
    private static UserIdsGenerator idsGenerator;

    private UserIdsGenerator() {

    }

    public static UserIdsGenerator getInstance() {
        if (idsGenerator == null) {
            idsGenerator = new UserIdsGenerator();
        }
        return idsGenerator;
    }

    public Integer generateId() {
        return lastGenId++;
    }

}
