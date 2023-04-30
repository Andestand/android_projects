package ru.project.examtest.data.inerfaces;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import ru.project.examtest.data.models.RoomTestOgeP;

@Dao
public interface TestOgeP_DAO {

    @Query("SELECT * FROM tests_oge_p")
    List<RoomTestOgeP> all();

    @Query("SELECT * FROM tests_oge_p WHERE text=:text AND correct_answer=:correct_answer")
    RoomTestOgeP isTest(String text, String correct_answer);

    @Query("SELECT * FROM tests_oge_p WHERE correct_answer=:correct_answer")
    RoomTestOgeP isCorrectAnswer(String correct_answer);

    @Insert
    void addTest(RoomTestOgeP... test);

    @Delete
    void delete(RoomTestOgeP test);

}
