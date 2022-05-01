package school21.spring.service.repositories;

import school21.spring.service.models.User;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {
    private DataSource dataSource;
    private final String queryId = "SELECT * FROM models.user WHERE id = ";
    private final String queryEmail = "SELECT * FROM models.user WHERE email = ?";
    private final String queryAll = "SELECT * FROM models.user";
    private final String queryUpdate = "UPDATE models.user SET email = ? WHERE id = ?";
    private final String queryDelete = "DELETE FROM models.user WHERE id = ";

    public UsersRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public User findById(Long id) {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(queryId + id);
            if (!resultSet.next())
                return null;
            return new User(resultSet.getLong(1), resultSet.getString(2));
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(queryAll);

            while (resultSet.next()) {
                userList.add(new User(resultSet.getLong(1), resultSet.getString(2)));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return userList.isEmpty() ? null : userList;
    }

    @Override
    public void save(User entity) {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            int executeUpdate = statement.executeUpdate("INSERT INTO models.user (id, email) VALUES (" + entity.getId() + ", '" + entity.getEmail() + "');");
            if (executeUpdate == 0)
                System.err.println("User wasn't saved with id: " + entity.getId());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void update(User entity) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(queryUpdate)) {
            statement.setString(1, entity.getEmail());
            statement.setLong(2, entity.getId());
            int executeUpdate = statement.executeUpdate();

            if (executeUpdate == 0)
                System.err.println("Can not update with user id: " + entity.getId());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(queryDelete + id)) {
            int executeUpdate = statement.executeUpdate();
            if (executeUpdate == 0)
                System.err.println("Not found user for id: " + id);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(queryEmail)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next())
                return Optional.empty();
            return Optional.of(new User(resultSet.getLong(1), resultSet.getString(2)));
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return Optional.empty();
    }
}