package edu.school21.chat.repositories;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {

    private final DataSource dataSource;

    public MessagesRepositoryJdbcImpl(DataSource source) {
        this.dataSource = source;
    }

    @Override
    public Optional<Message> findById(Long id) {
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            String idReq = "SELECT * FROM chat.message WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(idReq);
            resultSet.next();
            User user = new User(5L, "user", "user", null, null);
            Chatroom chatroom = new Chatroom(5L, "chatroom", null, null);
            return Optional.of(new Message((long) resultSet.getInt(1), user ,
                    chatroom, resultSet.getString("message"),
                    LocalDateTime.of(2022, 4, 26, 15, 1)));

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
