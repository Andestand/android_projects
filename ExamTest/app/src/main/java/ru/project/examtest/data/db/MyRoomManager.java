package ru.project.examtest.data.db;

import androidx.room.*;
import ru.project.examtest.data.inerfaces.*;
import ru.project.examtest.data.models.*;

@Database(
        entities = {
                RoomTeacher.class,
                RoomTerms.class,
                RoomTheory.class
        },
        version = 1
)
public abstract class MyRoomManager extends RoomDatabase {
    public abstract TeacherDAO teacherDAO();
    public abstract TermsDAO termsDAO();
    public abstract TheoryDAO theoryDAO();
}
