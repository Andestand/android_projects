package ru.project.examtest.domain.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;

public class Student {
    private String username;
    private String password;

    public Student(
            String username,
            String password
    ) {
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NonNull
    @Override
    public String toString() {
        return "RoomStudent{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
