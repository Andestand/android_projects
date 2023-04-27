package ru.project.examtest.data.inerfaces;

import androidx.room.*;
import java.util.List;
import ru.project.examtest.data.models.*;

@Dao
public interface TermsDAO {
    @Query("SELECT * FROM terms")
    List<RoomTerms> TermsAll();

    @Query("SELECT * FROM terms WHERE id IN (:id)")
    List<RoomTerms> TermById(int[] id);

    @Query("SELECT * FROM terms WHERE title IN (:title)")
    List<RoomTerms> TermByTitle(String[] title);

    @Query("SELECT * FROM terms WHERE description IN (:description)")
    List<RoomTerms> TermByDescription(String[] description);

    @Insert
    void AddTerm(RoomTerms... term);

    @Delete
    void delete(RoomTerms term);
}
