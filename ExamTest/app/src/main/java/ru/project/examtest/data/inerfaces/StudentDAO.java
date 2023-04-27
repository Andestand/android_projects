package ru.project.examtest.data.inerfaces;

import ru.project.examtest.data.models.RoomStudent;
import ru.project.examtest.domain.models.Student;

import androidx.room.*;
import java.util.List;

@Dao
public interface StudentDAO {
    @Query("SELECT * FROM students")
    List<RoomStudent> StudentsAll();

    @Query("SELECT * FROM students WHERE id IN (:id)")
    List<RoomStudent> StudentById(int[] id);

    @Query("SELECT * FROM students WHERE username  IN (:username)")
    RoomStudent StudentByUsername(String username);

    @Query("SELECT * FROM students WHERE password IN (:password)")
    RoomStudent StudentByPassword(String password);

    @Query("SELECT * FROM students WHERE username=:username AND password=:password")
    RoomStudent isStudent(String username, String password);

    @Insert
    void AddStudent(RoomStudent... teacher);

    @Delete
    void delete(RoomStudent teacher);
}
