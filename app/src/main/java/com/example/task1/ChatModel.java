package com.example.task1;

import java.sql.Timestamp;

public class ChatModel {
    String message;
    Integer id, userId, groupId;
    Timestamp createdAtTime;

    public ChatModel(String message, Integer id, Integer userId, Integer groupId, Timestamp createdAtTime) {
        this.message = message;
        this.id = id;
        this.userId = userId;
        this.groupId = groupId;
        this.createdAtTime = createdAtTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Timestamp getCreatedAtTime() {
        return createdAtTime;
    }

    public void setCreatedAtTime(Timestamp createdAtTime) {
        this.createdAtTime = createdAtTime;
    }
}
