package ru.project.examtest.data.inerfaces;

import androidx.room.*;
import java.util.List;
import ru.project.examtest.data.models.*;

@Dao
public interface TermsDAO {
    @Query("SELECT * FROM terms")
    List<RoomTerms> TermsAll();

    @Query("SELECT * FROM terms WHERE id IN (:arg0)")
    List<RoomTerms> TermById(int[] arg0);

    @Query("SELECT * FROM terms WHERE title IN (:arg1)")
    List<RoomTerms> TermByTitle(String[] arg1);

    @Query("SELECT * FROM terms WHERE description IN (:arg2)")
    List<RoomTerms> TermByDescription(String[] arg2);

    @Insert
    void AddTerm(RoomTerms... term);

    @Delete
    void delete(RoomTerms term);
}
