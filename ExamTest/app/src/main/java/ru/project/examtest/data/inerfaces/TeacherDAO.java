package ru.project.examtest.data.inerfaces;

import androidx.room.*;
import java.util.List;
import ru.project.examtest.data.models.*;

@Dao
public interface TeacherDAO {
    @Query("SELECT * FROM teachers")
    List<RoomTeacher> teachersAll();

    @Query("SELECT * FROM teachers WHERE id IN (:id)")
    List<RoomTeacher> TeacherById(int[] id);

    @Query("SELECT * FROM teachers WHERE username IN (:username)")
    List<RoomTeacher> TeacherByUsername(String[] username);

    @Query("SELECT * FROM teachers WHERE password IN (:password)")
    List<RoomTeacher> TeacherByPassword(String[] password);

    @Insert
    void AddTeacher(RoomTeacher... teacher);

    //void isTeacher(RoomTeacher teacher);

    @Delete
    void delete(RoomTeacher teacher);
}
