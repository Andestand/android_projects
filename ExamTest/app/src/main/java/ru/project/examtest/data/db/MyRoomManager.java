package ru.project.examtest.data.db;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.project.examtest.data.inerfaces.TeacherDAO;
import ru.project.examtest.data.models.RoomTeacher;

@Database(entities = {RoomTeacher.class}, version = 1)
public abstract class MyRoomManager extends RoomDatabase {
    public abstract TeacherDAO teacherDAO();
}
