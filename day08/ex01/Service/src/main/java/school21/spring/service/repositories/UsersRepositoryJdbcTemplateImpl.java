package school21.spring.service.repositories;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import school21.spring.service.models.User;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private final String idQuery = "SELECT * FROM models.user WHERE id = :id";
    private final String emQuery = "SELECT * FROM models.user WHERE email = :email";
    private final String alQuery = "SELECT * FROM models.user";
    private final String upQuery = "UPDATE models.user SET email = :email WHERE id = :id";
    private final String dlQuery = "DELETE FROM models.user WHERE id = :id";
    private final String inQuery = "INSERT INTO models.user (id, email) VALUES (:id, :email)";

    private class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setEmail(resultSet.getString("email"));
            return user;
        }
    }

    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public User findById(Long id) {
        User user = jdbcTemplate.query(idQuery,
                new MapSqlParameterSource().addValue("id", id),
                new UserRowMapper()).stream().findAny().orElse(null);

        return user;
    }

    @Override
    public void save(User entity) {
        int i = jdbcTemplate.update(inQuery, new MapSqlParameterSource()
                .addValue("id", entity.getId())
                .addValue("email", entity.getEmail()));

        if (i == 0) {
            System.err.println("User wasn't saved with id: " + entity.getId());
        }
    }

    @Override
    public List<User> findAll() {
        List<User> users = jdbcTemplate.query(alQuery, new UserRowMapper());
        return users;
    }

    @Override
    public void delete(Long id) {
        int i = jdbcTemplate.update(dlQuery, new MapSqlParameterSource()
                .addValue("id", id));
        if (i == 0) {
            System.err.println("Not found user for id: " + id);
        }
    }

    @Override
    public void update(User entity) {
        int i = jdbcTemplate.update(upQuery, new MapSqlParameterSource()
                .addValue("id", entity.getId())
                .addValue("email", entity.getEmail()));

        if (i == 0) {
            System.err.println("Can not update with user id: " + entity.getId());
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        User user = jdbcTemplate.query(emQuery,
                new MapSqlParameterSource().addValue("email", email),
                new UserRowMapper()).stream().findAny().orElse(null);
        return Optional.ofNullable(user);
    }
}