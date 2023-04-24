package ru.project.examtest.data.inerfaces;

import androidx.room.*;
import java.util.List;
import ru.project.examtest.data.models.*;

@Dao
public interface TheoryDAO {

    @Query("SELECT * FROM theorys")
    List<RoomTheory> getTheoryAll();

    @Query("SELECT * FROM theorys WHERE id IN (:arg0)")
    List<RoomTheory> TheoryById(int[] arg0);

    @Query("SELECT * FROM theorys WHERE text IN (:arg1)")
    List<RoomTeacher> TeacherByUsername(String[] arg1);

    @Insert
    void AddTheory(RoomTheory... theory);

    @Delete
    void delete(RoomTheory theory);
}
