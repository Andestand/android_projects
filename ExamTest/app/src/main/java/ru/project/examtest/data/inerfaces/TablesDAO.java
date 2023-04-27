package ru.project.examtest.data.inerfaces;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ru.project.examtest.data.models.RoomDiagrams;
import ru.project.examtest.data.models.RoomTables;

@Dao
public interface TablesDAO {
    @Query("SELECT * FROM tables")
    List<RoomTables> TablesAll();

    @Query("SELECT * FROM tables WHERE id IN (:id)")
    List<RoomTables> TablesById(int[] id);

    @Query("SELECT * FROM tables WHERE title IN (:title)")
    List<RoomTables> TablesByTitle(String[] title);

    @Query("SELECT * FROM tables WHERE link IN (:link)")
    List<RoomTables> TablesByLink(String[] link);

    @Insert
    void AddTables(RoomTables... tables);

    @Delete
    void delete(RoomTables tables);
}
