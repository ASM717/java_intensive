package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {
    private Long id;
    private String login;
    private String password;
    private List<Chatroom> createdRoomsList;
    private List<Chatroom> chatroomList;

    public User() {
        this.id = null;
        this.login = null;
        this.password = null;
        this.createdRoomsList = null;
        this.chatroomList = null;
    }

    public User(Long id, String login, String password, List<Chatroom> createdRoomsList, List<Chatroom> chatroomList) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.createdRoomsList = createdRoomsList;
        this.chatroomList = chatroomList;
    }

    public User(Long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.createdRoomsList = null;
        this.chatroomList = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Chatroom> getCreatedRoomsList() {
        return createdRoomsList;
    }

    public void setCreatedRoomsList(List<Chatroom> createdRoomsList) {
        this.createdRoomsList = createdRoomsList;
    }

    public List<Chatroom> getChatroomList() {
        return chatroomList;
    }

    public void setChatroomList(List<Chatroom> chatroomList) {
        this.chatroomList = chatroomList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, createdRoomsList, chatroomList);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", createdRoomsList=" + createdRoomsList +
                ", chatroomList=" + chatroomList +
                '}';
    }
}
