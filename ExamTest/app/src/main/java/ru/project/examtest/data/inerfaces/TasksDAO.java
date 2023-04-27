package ru.project.examtest.data.inerfaces;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ru.project.examtest.data.models.RoomBasicFormula;
import ru.project.examtest.data.models.RoomTasks;

@Dao
public interface TasksDAO {
    @Query("SELECT * FROM tasks")
    List<RoomTasks> TaskAll();

    @Query("SELECT * FROM tasks WHERE id IN (:id)")
    List<RoomTasks> TaskById(int[] id);

    @Query("SELECT * FROM tasks WHERE title IN (:title)")
    List<RoomTasks> TaskByTitle(String[] title);

    @Query("SELECT * FROM tasks WHERE link IN (:link)")
    List<RoomTasks> TaskByLink(String[] link);

    @Insert
    void AddTask(RoomTasks... tasks);

    @Delete
    void delete(RoomTasks tasks);
}
