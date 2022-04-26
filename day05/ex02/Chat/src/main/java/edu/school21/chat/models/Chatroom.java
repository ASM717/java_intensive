package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class Chatroom {
    private Long id;
    private String chatRoomName;
    private User owner;
    private List<Message> messages;

    public Chatroom(Long id, String chatRoomName, User owner, List<Message> messages) {
        this.id = id;
        this.chatRoomName = chatRoomName;
        this.owner = owner;
        this.messages = messages;
    }

    public Chatroom(Long id, String chatRoomName) {
        this.id = id;
        this.chatRoomName = chatRoomName;
        this.owner = null;
        this.messages = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChatRoomName() {
        return chatRoomName;
    }

    public void setChatRoomName(String chatRoomName) {
        this.chatRoomName = chatRoomName;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chatroom chatroom = (Chatroom) o;
        return Objects.equals(id, chatroom.id) && Objects.equals(chatRoomName, chatroom.chatRoomName)
                && Objects.equals(owner, chatroom.owner) && Objects.equals(messages, chatroom.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chatRoomName, owner, messages);
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + chatRoomName + '\'' +
                ", creator=" + owner +
                ", messages=" + messages +
                '}' + ',';
    }
}