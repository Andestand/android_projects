package ru.project.examtest.data.inerfaces;

import androidx.room.*;
import java.util.List;
import ru.project.examtest.data.models.*;

@Dao
public interface TeacherDAO {
    @Query("SELECT * FROM teachers")
    List<RoomTeacher> teachersAll();

    @Query("SELECT * FROM teachers WHERE id IN (:arg0)")
    List<RoomTeacher> TeacherById(int[] arg0);

    @Query("SELECT * FROM teachers WHERE username IN (:arg1)")
    List<RoomTeacher> TeacherByUsername(String[] arg1);

    @Query("SELECT * FROM teachers WHERE password IN (:arg2)")
    List<RoomTeacher> TeacherByPassword(String[] arg2);

    @Insert
    void AddTeacher(RoomTeacher... teacher);

    //void isTeacher(RoomTeacher teacher);

    @Delete
    void delete(RoomTeacher teacher);
}
