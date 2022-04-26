package edu.school21.chat.repositories;

import edu.school21.chat.app.NotSavedSubEntityException;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import javax.sql.DataSource;
import java.sql.*;
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

    @Override
    public void save(Message message) throws NotSavedSubEntityException {
        String takeMes = "INSERT into chat.message (room_id, sender, message, time)" +
                " VALUES (" +
                message.getRoom().getId() + ", " +
                message.getAuthor().getId() + ", " +
                "'" + message.getText() + "'" + ", " +
                "'" + message.getDateTime() + "'" +
                ");";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(takeMes, Statement.RETURN_GENERATED_KEYS)) {
            statement.execute();
            ResultSet key = statement.getGeneratedKeys();
            key.next();
            message.setId((long) key.getInt(1));
        } catch (SQLException e) {
            throw new NotSavedSubEntityException(e.getMessage());
        }
    }
}
