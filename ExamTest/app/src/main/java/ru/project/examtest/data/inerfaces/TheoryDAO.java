package ru.project.examtest.data.inerfaces;

import androidx.room.*;
import java.util.List;
import ru.project.examtest.data.models.*;

@Dao
public interface TheoryDAO {

    @Query("SELECT * FROM theorys")
    List<RoomTheory> getTheoryAll();

    @Query("SELECT * FROM theorys WHERE id IN (:id)")
    List<RoomTheory> TheoryById(int[] id);

    @Query("SELECT * FROM theorys WHERE text IN (:text)")
    List<RoomTeacher> TeacherByUsername(String[] text);

    @Insert
    void AddTheory(RoomTheory... theory);

    @Delete
    void delete(RoomTheory theory);
}
