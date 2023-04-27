package ru.project.examtest.data.inerfaces;

import androidx.room.*;
import java.util.List;
import ru.project.examtest.data.models.RoomBasicFormula;

@Dao
public interface BasicFormulasDAO {
    @Query("SELECT * FROM basic_formulas")
    List<RoomBasicFormula> BasicFormulasAll();

    @Query("SELECT * FROM basic_formulas WHERE id IN (:id)")
    List<RoomBasicFormula> BasicFormulasById(int[] id);

    @Query("SELECT * FROM basic_formulas WHERE formula IN (:formula)")
    List<RoomBasicFormula> BasicFormulasByTitle(String[] formula);

    @Query("SELECT * FROM basic_formulas WHERE description IN (:description)")
    List<RoomBasicFormula> BasicFormulasByDescription(String[] description);

    @Insert
    void AddBasicFormulas(RoomBasicFormula... bf);

    @Delete
    void delete(RoomBasicFormula bf);
}
