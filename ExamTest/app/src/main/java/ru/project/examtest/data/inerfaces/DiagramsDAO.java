package ru.project.examtest.data.inerfaces;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ru.project.examtest.data.models.RoomBasicFormula;
import ru.project.examtest.data.models.RoomDiagrams;

@Dao
public interface DiagramsDAO {
    @Query("SELECT * FROM diagrams")
    List<RoomDiagrams> DiagramsAll();

    @Query("SELECT * FROM diagrams WHERE id IN (:id)")
    List<RoomDiagrams> DiagramsById(int[] id);

    @Query("SELECT * FROM diagrams WHERE title IN (:title)")
    List<RoomDiagrams> DiagramsByTitle(String[] title);

    @Query("SELECT * FROM diagrams WHERE link IN (:link)")
    List<RoomDiagrams> DiagramsByLink(String[] link);

    @Insert
    void AddDiagrams(RoomDiagrams... diagrams);

    @Delete
    void delete(RoomDiagrams diagrams);
}
