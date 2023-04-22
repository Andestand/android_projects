package ru.project.examtest.data.inerfaces;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

import ru.project.examtest.data.models.RoomTeacher;
import ru.project.examtest.data.models.RoomTheory;
import ru.project.examtest.domain.models.Theory;

@Dao
public interface TheoryDAO {

    @Query("SELECT * FROM theorys")
    List<Theory> getTheoryAll();

    @Query("SELECT * FROM theorys WHERE id IN (:id)")
    List<RoomTheory> TheoryById(int[] id);

    @Query("SELECT * FROM theorys WHERE text IN (:text)")
    List<RoomTeacher> TeacherByUsername(String[] text);
    
    @Insert
    void AddTheory(RoomTheory... theory);

    @Delete
    void delete(RoomTheory theory);
}
